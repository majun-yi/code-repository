package com.dalaoyang.service.impl;


import com.dalaoyang.entity.PageCriteriaDTP;
import com.dalaoyang.entity.PageVO;
import com.dalaoyang.entity.StudentEntity;
import com.dalaoyang.entity.User;
import com.dalaoyang.repository.MyRepository;
import com.dalaoyang.repository.StuRepository;
import com.dalaoyang.service.IEMPService;
import com.github.wenhao.jpa.Specifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 人员管理 业务
 */
@Service
@Component
public class EMPServiceImpl implements IEMPService {
    private static final Boolean IS_NOT_DELETE = false;
    private static final Boolean IS_DELETE = true;

    @Autowired
    private MyRepository myJpaRepository;

    /**
     * 分页+条件（名称userName模糊查询） 查询信息
     *
     * @param queryDto
     * @return page
     */
    @Override
    public PageVO<User> findByPage(PageCriteriaDTP queryDto, Integer size, Integer page) {
        //1.设置页码和数量
        PageRequest pageRequest = new PageRequest(page - 1, size);
        //2.设置名称查询条件
        Specification<User> specification = Specifications.<User>and()
                .like(queryDto.getUserName() != null, "userName", "%" + queryDto.getUserName() + "%")
                .eq("sex", queryDto.getSex())
                .between("birthday", queryDto.getBirthday().get(0), queryDto.getBirthday().get(1))
                .build();

        Page<User> pageInfo = myJpaRepository.findAll(specification, pageRequest);
        PageVO<User> pageVO = new PageVO<>();
        if (pageInfo != null) {
            pageVO.setTotalElement(pageInfo.getTotalElements());
            pageVO.setData(pageInfo.getContent());
        }
        return pageVO;
    }

}
