package com.my_annotation.entity;

import com.my_annotation.service.MyAnnotation;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2020/8/16 17:56
 */
@MyAnnotation(name = "mjy",score={10,20,30})
public class Student {
    //@MyAnnotation(name = "mjy",score={10,20,30})

    public void study(int times){
        for (int i = 0; i < times; i++) {
            System.out.println("Good start!!");
        }
    }
}
