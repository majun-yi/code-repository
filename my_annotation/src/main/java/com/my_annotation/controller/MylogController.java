package com.my_annotation.controller;

import com.my_annotation.util.MyLog;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2020/8/17 8:44
 */
@RestController
public class MylogController {

    @RequestMapping("/testMyLog")
    @MyLog(requestUrl = "testMyLog请求")
    public String testMyLog1() {
        return "Hello myLog!";
    }
}
