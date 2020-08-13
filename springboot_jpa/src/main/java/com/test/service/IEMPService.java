package com.test.service;
import com.test.entity.PageCriteriaDTP;
import com.test.entity.PageVO;
import com.test.entity.User;

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
