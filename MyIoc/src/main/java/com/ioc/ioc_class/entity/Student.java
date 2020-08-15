package com.ioc.ioc_class.entity;

import com.ioc.ioc_interface.MyIoc;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2020/8/15 17:47
 */
@MyIoc
public class Student {
    public String play(){
        return "student:"+ this.toString();
    }
}
