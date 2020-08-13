package com.dalaoyang.service.impl;


import com.dalaoyang.entity.*;
import com.dalaoyang.enums.HTMLPageEnum;
import com.dalaoyang.repository.StuRepository;
import com.dalaoyang.repository.TeaRepository;
import com.dalaoyang.service.IStuService;
import com.dalaoyang.service.ITeaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


/**
 * 人员管理 业务
 */
@Service
@Component
public class TeaServiceImpl implements ITeaService {

    @Autowired
    private TeaRepository teaRepository;

    private Logger logger = LoggerFactory.getLogger(TeaServiceImpl.class);
    @Override
    public PageVO<User> findByPage(PageCriteriaDTP queryDto, Integer size, Integer page) {
        return null;
    }

    @Override
    public TeacherVO findByID(Integer id) {
        TeacherEntity teacherEntity = teaRepository.findOne(id);
        TeacherVO teacherVO = new TeacherVO(teacherEntity);
        return teacherVO;
    }


    public void test(Integer i) throws Exception {
        switch (i){
            case 1:{
                logger.info("打印枚举值的toString(),{}:", HTMLPageEnum.PAGE_LIST.toString());
                break;
            }
            case 2:{
                logger.info("打印code,{}",HTMLPageEnum.getCode("列表页面"));
                break;
            }
            case 3:{
                logger.info("打印name,{}",HTMLPageEnum.getName(2));
                break;
            }
            default:
                throw new Exception("传值空异常");
        }
    }
}
