package com.my_annotation;

import com.my_annotation.service.MyAnnotation;

import java.lang.reflect.Method;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2020/8/16 18:07
 */
public class testMyAnnotation {
    /**
     * 通过反射的方式获取自定义注解的值
     */
    public static void main(String[] args) {
        try {
            //获取Student的class对象
            Class stuClass = Class.forName("com.my_annotation.entity.Student");
            //注意：形参非Integer.class
            Method stuMethod = stuClass.getMethod("study", int.class);

            if(stuClass.isAnnotationPresent(MyAnnotation.class)){
                System.out.println("Student类被MyAnnotation修饰");
                MyAnnotation myAnnotation = (MyAnnotation) stuClass.getAnnotation(MyAnnotation.class);
                System.out.println("name:"+myAnnotation.name());
            }else {
                System.out.println("未加载到MyAnnotation");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
