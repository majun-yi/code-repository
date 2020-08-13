package com.dalaoyang.repository;

import com.dalaoyang.entity.StudentEntity;
import com.dalaoyang.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author dalaoyang
 * @Description
 * @project springboot_learn
 * @package com.dalaoyang.Repository
 * @email 397600342@qq.com
 * @date 2018/4/7
 */
public interface TeaRepository extends JpaRepository<TeacherEntity,Integer> , JpaSpecificationExecutor<TeacherEntity> {
}
