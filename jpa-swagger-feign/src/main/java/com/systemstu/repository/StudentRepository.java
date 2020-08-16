package com.systemstu.repository;

import com.systemstu.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
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
    /**
     * 注意: (因为表名和实体名大多都一致,若有区别.则需要区分)
     * nativeQuery = true 操作的是表名,
     * 否则 使用的是 jpql-->操作的是实体名称
     */
    @Query(value = "select id,name,sex from student where 1 = 1 and isDelete = :isDelete",nativeQuery = true)
    Student getOneInfo(@Param(value = "isDelete")Integer id);

    @Query(value = "select id,name,sex from student where 1 = 1 and id = :id",nativeQuery = true)
    Student getOneInfoByID(@Param(value = "id")Integer id);

    /**
     * @return 返回值为1 则表示 更新的数据为 一条
     */
    @Query(value = "update student set isDelete = true where 1 = 1 and id = :id",nativeQuery = true)
    @Modifying
    Integer updateStudent(@Param(value = "id")Integer id);
}
