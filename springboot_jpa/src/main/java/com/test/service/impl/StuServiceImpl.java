package com.test.service.impl;


import com.test.entity.*;
import com.test.repository.StuRepository;
import com.test.service.IStuService;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.List;


/**
 * 人员管理 业务
 */
@Service
@Component
public class StuServiceImpl implements IStuService {

    @Autowired
    private StuRepository stuRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public PageVO<User> findByPage(PageCriteriaDTP queryDto, Integer size, Integer page) {
        return null;
    }

    @Override
    public StudentEntity findByID(Integer id) {
        StudentEntity stu = stuRepository.findOne(id);

        return stuRepository.findOne(id);
    }

    @Override
    public StudentVO findByName(String name) {
        StudentEntity entity = stuRepository.findByName(name);
        StudentVO studentVO = new StudentVO(entity);
        return studentVO;
    }

    @Override
    public Integer save(StudentEntity studentEntity){
        return  stuRepository.save(studentEntity).getId();
    }

    @Override
    public StudentVO findByStatus() {
        StudentEntity entity = stuRepository.findByStatus();
        StudentVO studentVO = new StudentVO(entity);
        findBySQL();
        return studentVO;
    }

    /**
     * 通过SQL方式查询
     * @return
     */
    @Override
    public List<StudentVO> findBySQL() {
        String sql = "select id,name,sex from student";
        Query query = entityManager.createQuery(sql);
        query.unwrap(SQLQuery.class).setResultTransformer(Transformers.aliasToBean(StudentVO.class));
        return  query.getResultList();
    }
}
