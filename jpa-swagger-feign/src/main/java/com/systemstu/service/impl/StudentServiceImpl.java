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

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Description 通过实体的方式直接进行操作(可用但不太规范, 可能有未设计的冗余字段, 暴露部分信息)
 * @Author Administrator
 * @Date 2020/8/11 14:40
 */
@Service
public class StudentServiceImpl implements IStudentService {
    private static Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    private StudentRepository studentRepository;

    @Autowired
    public void constructor(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Autowired
    EntityManager entityManager;

    public Student getOneInfo(Integer id) {
        return studentRepository.getOneInfo(id);
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
                .like(!StringUtils.isEmpty(student.getName()), "name", "%" + student.getName() + "%")
                .eq(!StringUtils.isEmpty(student.getSex()), "sex", student.getSex())
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
        //  Student one = studentRepository.getOne(id);

        Optional<Student> optional = studentRepository.findById(id);
        if (optional.get() == null) {
            return id;
        } else {
            return null;
        }
    }

    @Override
    public Integer deleteStudent(Integer id) {
        // Student student = studentRepository.getOne(id);
        Student student = studentRepository.getOneInfo(id);
        Integer studentId = null;
        if (student != null && student.getId() != null) {
            studentId = student.getId();
            student.setIsDelete(false);
        }
        return studentId;
    }

  /*  @Override
    public Integer updateStudent(Student student) {
        Student one = null;
        if (student.getId() != null) {
            Specification specification = Specifications.<Student>and().eq("id",student.getId()).build();
           // one = studentRepository.getOneInfoByID(student.getId());
            Student one1 = studentRepository.getOne(student.getId());
            Optional one2 = studentRepository.findOne(specification);
            if (!StringUtils.isEmpty(student.getName())) {
                one.setName(student.getName());
            }
            if (!StringUtils.isEmpty(student.getSex())) {
                one.setSex(student.getSex());
            }
            return student.getId();
        }
        return null;
    }*/

    /**
     * 固定更新语句的写法,不动态,不建议
     *
     * @param student
     * @return
     */
    public Integer updateStudent2(Student student) {
        StringBuffer sql = new StringBuffer();
        //Student one = studentRepository.getOne(student.getId()); -- 此方法有问题(不能查询到具体的数值,而是引用),有待研究
        //logger.info("one:,{}",one);
        Optional<Student> stu = studentRepository.findById(student.getId());
        sql.append("update Student set name =:name where id = :id ");
        Query query = entityManager.createQuery(sql.toString());
        query.setParameter("name", student.getName()).setParameter("id", student.getId());
        int i = query.executeUpdate();
        return i;
    }

    @Override
    @Transactional
    public Integer updateStudent(Student student) {
        Optional<Student> entity = studentRepository.findById(student.getId());
        Integer id = null;
        if (entity.isPresent()) {
            id = student.getId();
            if (!StringUtils.isEmpty(student.getName())) {
                entity.get().setName(student.getName());
            }
            if (!StringUtils.isEmpty(student.getSex())) {
                entity.get().setSex(student.getSex());
            }
            Student s = new Student(entity);
            studentRepository.save(s);
        }
        return id;
    }
}
