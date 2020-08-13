package com.dalaoyang.service;
import com.dalaoyang.entity.PageCriteriaDTP;
import com.dalaoyang.entity.PageVO;
import com.dalaoyang.entity.StudentEntity;
import com.dalaoyang.entity.User;
import org.springframework.stereotype.Component;

/**
 * 人员管理 业务
 */
public interface IEMPService {


    /**
     * 分页+条件（名称userName模糊查询） 查询信息
     * @param queryDto
     * @return page
     */
    PageVO<User> findByPage(PageCriteriaDTP queryDto, Integer size, Integer page);

}
