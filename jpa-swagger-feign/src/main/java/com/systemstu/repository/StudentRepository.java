package com.systemstu.repository;

import com.systemstu.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 学生管理的 jpa接口
 * 提供学生信息的增删该查
 */
public interface StudentRepository extends JpaRepository<Student,Integer>, JpaSpecificationExecutor<Student> {
}
