package com.systemstu.service.impl;

import com.github.wenhao.jpa.Specifications;
import com.systemstu.pojo.Student;
import com.systemstu.pojo.dto.AddStuDTO;
import com.systemstu.pojo.dto.StudentDTO;
import com.systemstu.pojo.vo.PageVO;
import com.systemstu.pojo.vo.StudentVO;
import com.systemstu.repository.StudentRepository;
import com.systemstu.service.IStudentVOService;
import com.systemstu.util.ExceptionEnum;
import com.systemstu.util.MyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Description 通过实体的方式直接进行操作(可用但不太规范, 可能有未设计的冗余字段, 暴露部分信息)
 * @Author Administrator
 * @Date 2020/8/11 14:40
 */
@Service
public class StudentVOServiceImpl implements IStudentVOService {
    private static Logger logger = LoggerFactory.getLogger(StudentVOServiceImpl.class);

    private StudentRepository studentRepository;

    @Autowired
    public void constructor(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Autowired
    EntityManager entityManager;


    public StudentVO getOneInfo(Integer id) {
        Student oneInfo = studentRepository.getOneInfo(id);
        StudentVO studentVO = new StudentVO(oneInfo);
        return studentVO;
    }

    @Override
    public String getStr() {
        return "我是实现类方法!";
    }

    @Override
    public List<StudentVO> getAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        List<StudentVO> studentVOList = new ArrayList<>();
        BeanUtils.copyProperties(studentList, studentVOList);
        // 集合 类型转换 List<A>-->list<B> jdk1.8的流
        List<StudentVO> collect = studentList.stream().map(student -> new StudentVO(student)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public StudentVO getStudentByID(Integer id) {
        List<Integer> list = new ArrayList<>();
        list.add(id);
        List<Student> stuList = studentRepository.findAllById(list);

        if (stuList.size() > 0) {
            StudentVO studentVO = new StudentVO();
            BeanUtils.copyProperties(stuList.get(0),studentVO);
            return studentVO;
        } else {
            return null;
        }
    }

    @Override
    public StudentVO getStudentByID2(Integer id) {
        Optional<Student> optional = studentRepository.findById(id);
        logger.info("optional：{}", optional);
        StudentVO studentVO = null;
        if (optional.isPresent()) {
            studentVO = new StudentVO();
            BeanUtils.copyProperties(optional.get(), studentVO);
        }
        return studentVO;
    }

    @Override
    public PageVO pageQuery(StudentDTO student, Integer pageNum, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNum-1, pageSize);
        Specification<Student> specification = Specifications.<Student>and()
                .like(!StringUtils.isEmpty(student.getName()), "name", "%" + student.getName() + "%")
                .eq(!StringUtils.isEmpty(student.getSex()), "sex", student.getSex())
                .build();
        Page<Student> page = studentRepository.findAll(specification, pageRequest);
        PageVO<StudentVO> studentVO = new PageVO<>();
        BeanUtils.copyProperties(page, studentVO);
        studentVO.setTotal(page.getTotalElements());
        // List<StudentVO> collect = page.stream().map(stuVO -> new StudentVO(stuVO.getId(), stuVO.getName(), stuVO.getSex())).collect(Collectors.toList());

        return studentVO;
    }

    @Override
    public Integer addStudent(AddStuDTO studentDTO) {
        Student student = new Student();
        BeanUtils.copyProperties(studentDTO, student);
        return studentRepository.save(student).getId();
    }

    @Override
    @Transactional
    public Integer deleteStudentReally(Integer id) {
        Optional<Student> optional = studentRepository.findById(id);
        if (optional.isPresent()) {
            studentRepository.deleteById(id);
            return id;
        } else {
            throw new MyException(ExceptionEnum.MESSAGE_NOT_FOUND.getMessage());
        }
    }

    @Override
    @Transactional
    public Integer deleteStudent(Integer id) {
        Optional<Student> byId = studentRepository.findById(id);
        if (byId.isPresent()) {
            Integer integer = studentRepository.updateStudent(id);
            return integer;
        }
        return null;
    }

    @Override
    @Transactional
    public Integer updateStudent(StudentDTO studentDTO) {
        Optional<Student> student = studentRepository.findById(studentDTO.getId());
        Integer id = null;
        if (student.isPresent()) {
            id = studentDTO.getId();
            if (!StringUtils.isEmpty(studentDTO.getName())) {
                student.get().setName(studentDTO.getName());
            }
            if (!StringUtils.isEmpty(studentDTO.getSex())) {
                student.get().setSex(studentDTO.getSex());
            }
            Student stu = new Student();
            BeanUtils.copyProperties(student.get(), stu);
            studentRepository.save(stu);
        }
        return id;
    }
}
