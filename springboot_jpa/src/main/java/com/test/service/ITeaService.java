package com.test.service;
import com.test.entity.*;

/**
 * 人员管理 业务
 */
public interface ITeaService {


    /**
     * 分页+条件（名称userName模糊查询） 查询信息
     * @param queryDto
     * @return page
     */
    PageVO<User> findByPage(PageCriteriaDTP queryDto, Integer size, Integer page);

    /**
     * 查询所有的老师
     */
    TeacherVO findByID(Integer id);

    void test(Integer id) throws Exception;
}
