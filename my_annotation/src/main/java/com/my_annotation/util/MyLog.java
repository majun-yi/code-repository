package com.my_annotation.util;

import java.lang.annotation.*;

@Target(ElementType.METHOD)// 类级别的注解
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface MyLog {
    /**
     * 是否开启
     */
   // boolean enableOpen() default false;

    /**
     * 请求地址
     */
    String requestUrl();

}
