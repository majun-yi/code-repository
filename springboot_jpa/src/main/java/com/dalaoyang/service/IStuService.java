package com.dalaoyang.service;
import com.dalaoyang.entity.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 人员管理 业务
 */
public interface IStuService {


    /**
     * 分页+条件（名称userName模糊查询） 查询信息
     * @param queryDto
     * @return page
     */
    PageVO<User> findByPage(PageCriteriaDTP queryDto, Integer size, Integer page);

    /**
     * 查询所有的学生
     */
    StudentEntity findByID(Integer id);

    StudentVO findByName(String name );

    Integer save(StudentEntity studentEntity);

    StudentVO findByStatus();

    List<StudentVO> findBySQL();
}
