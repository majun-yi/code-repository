package com.systemstu.service.impl;

import com.systemstu.pojo.Student;
import com.systemstu.repository.StudentRepository;
import com.systemstu.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author Administrator
 * @Date 2020/8/11 14:40
 */
@Service
public class StudentServiceImpl implements IStudentService {

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
        return null;
    }

    @Override
    public Page<Student> pageQuery(Student student, Integer pageNum, Integer pageSize) {
        return null;
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
