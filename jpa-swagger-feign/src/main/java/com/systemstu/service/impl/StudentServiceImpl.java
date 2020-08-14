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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Description
 * @Author Administrator
 * @Date 2020/8/11 14:40
 */
@Service
public class StudentServiceImpl implements IStudentService {
private static Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
    @Autowired
    private StudentRepository studentRepository;

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
        logger.info("optional：,{}",stuList);
        return stuList.get(0);
    }

    @Override
    public Optional<Student> getStudentByID2(Integer id) {
        Optional<Student> optional = studentRepository.findById(id);
        logger.info("optional：,{}",optional);
        return optional;
    }

    @Override
    public Page<Student> pageQuery(Student student, Integer pageNum, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageSize,pageNum);

        Specification<Student> specification = Specifications.<Student>and()
                .like(student.getName()!=null ,"name","%"+student.getName()+"%")
                .eq(student.getSex()!=null , "sex",student.getSex())
                .build();

        return studentRepository.findAll(specification, pageRequest);
    }

    @Override
    public Integer addStudent(Student student) {
        return null;
    }

    @Override
    public Integer deleteStudentReally(Integer id) {
        return null;
    }

    @Override
    public Integer deleteStudent(Integer id) {
        return null;
    }

    @Override
    public Integer updateStudent(Student student) {
        return null;
    }
}
