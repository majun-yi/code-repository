package com.test.repository;

import com.test.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TeaRepository extends JpaRepository<TeacherEntity,Integer> , JpaSpecificationExecutor<TeacherEntity> {
}
