package com.systemstu.service;

import com.systemstu.pojo.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IStudentService {
    String getStr();

    List<Student> getAllStudents();

    Student getStudentByID(Integer id);

    Page<Student> pageQuery(Student student, Integer pageNum, Integer pageSize);

    Integer addStudent(Student student);

    Integer deleteStudentReally(Integer id);

    Integer deleteStudent(Integer id);

    Integer updateStudent(Student student);
}
