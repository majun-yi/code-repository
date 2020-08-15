package com.systemstu.service.impl;

import com.github.wenhao.jpa.Specifications;
import com.systemstu.pojo.Student;
import com.systemstu.repository.StudentRepository;
import com.systemstu.service.IStudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Description 通过实体的方式直接进行操作(可用但不太规范,可能有未设计的冗余字段,暴露部分信息)
 * @Author Administrator
 * @Date 2020/8/11 14:40
 */
@Service
public class StudentServiceImpl implements IStudentService {
    private static Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    private StudentRepository studentRepository;
    @Autowired
    public void constructor(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    @Override
    public String getStr() {
        return "我是实现类方法!";
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentByID(Integer id) {
        List<Integer> list = new ArrayList<>();
        list.add(id);
        List<Student> stuList = studentRepository.findAllById(list);
        logger.info("optional：,{}", stuList);
        return stuList.get(0);
    }

    @Override
    public Optional<Student> getStudentByID2(Integer id) {
        Optional<Student> optional = studentRepository.findById(id);
        logger.info("optional：,{}", optional);
        return optional;
    }

    @Override
    public Page<Student> pageQuery(Student student, Integer pageNum, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageSize, pageNum);

        Specification<Student> specification = Specifications.<Student>and()
                .like(student.getName() != null, "name", "%" + student.getName() + "%")
                .eq(student.getSex() != null, "sex", student.getSex())
                .build();

        return studentRepository.findAll(specification, pageRequest);
    }

    @Override
    public Integer addStudent(Student student) {
        return studentRepository.save(student).getId();
    }

    @Override
    @Transactional
    public Integer deleteStudentReally(Integer id) {
        studentRepository.deleteById(id);
        //删除完之后再次进行查询,若无值,则说明删除成功
        Student one = studentRepository.getOne(id);
        if (one == null) {
            return id;
        } else {
            return null;
        }
    }

    @Override
    public Integer deleteStudent(Integer id) {
        Student student = studentRepository.getOne(id);
        Integer studentId = null;
        if (student != null) {
            studentId = student.getId();
            student.setIsDelete(false);
        }
        return studentId;
    }

    @Override
    public Integer updateStudent(Student student) {
        Student one = null;
        if (student.getId() != null) {
            one = studentRepository.getOne(student.getId());
            if (!StringUtils.isEmpty(student.getName())) {
                one.setName(student.getName());
            }
            if (!StringUtils.isEmpty(student.getSex())) {
                one.setSex(student.getSex());
            }
            return student.getId();
        }
        return null;
    }
}
