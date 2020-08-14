package com.systemstu.service;

import com.systemstu.pojo.Student;
import com.systemstu.pojo.StudentDTO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    String getStr();

    List<Student> getAllStudents();

    Student getStudentByID(Integer id);

    Optional<Student> getStudentByID2(Integer id);

    Page<Student> pageQuery(Student student, Integer pageNum, Integer pageSize);

    Integer addStudent(Student student);

    Integer deleteStudentReally(Integer id);

    Integer deleteStudent(Integer id);

    Integer updateStudent(Student student);
}
