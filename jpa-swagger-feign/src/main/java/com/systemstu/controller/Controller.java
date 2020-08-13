package com.systemstu.controller;

import com.systemstu.service.IStudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@Api(value = "管理系统Api" )
@RestController
public class Controller {



    private IStudentService iStudentService;
    @Autowired
    public void init(IStudentService iStudentService){
        this.iStudentService = iStudentService;
    }

    @ApiOperation(value = "测试方法的Api")
    @GetMapping("/test")
    public String test(){
        return iStudentService.getStr();
    }
}
