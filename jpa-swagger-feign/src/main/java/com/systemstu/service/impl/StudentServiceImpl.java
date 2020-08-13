package com.systemstu.service.impl;

import com.systemstu.service.IStudentService;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2020/8/11 14:40
 */
@Service
public class StudentServiceImpl implements IStudentService {

    @Override
    public String getStr() {
        return "我是实现类方法!";
    }
}
