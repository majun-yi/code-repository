package com.test.repository;

import com.test.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StuRepository extends JpaRepository<StudentEntity,Integer> , JpaSpecificationExecutor<StudentEntity> {

    //@Query(" select s from StudentEntity s where s.name = :name ")
    @Query(value = " select * from student  where name = :name",nativeQuery = true)
    StudentEntity findByName(@Param("name") String name);

    @Query(value = " select * from student  where isDelete = 0 ",nativeQuery = true)
    StudentEntity findByStatus();
}
