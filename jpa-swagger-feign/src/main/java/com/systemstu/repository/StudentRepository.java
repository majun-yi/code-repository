package com.systemstu.repository;

import com.systemstu.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * 学生管理的 jpa接口
 * 提供学生信息的增删该查
 */
public interface StudentRepository extends JpaRepository<Student,Integer>, JpaSpecificationExecutor<Student> {
    /**
    * @Description: 根据ID查询单个信息
    * @Author: mjy
    * @Date: 2020/8/15 11:39
    * @Param Integer id
    * @return Student
    */
    @Query(value = "select id,name,sex from student where 1 = 1 and isDelete = :isDelete",nativeQuery = true)
    Student getOneInfo(@Param(value = "isDelete")Integer id);

}
