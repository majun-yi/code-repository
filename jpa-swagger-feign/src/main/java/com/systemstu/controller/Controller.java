package com.systemstu.controller;

import com.systemstu.pojo.Student;
import com.systemstu.service.IStudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "学生单模块管理" )
@RestController
public class Controller {


    /**
     * 构造方法式注入-->相当于@Autowire
     */
    private IStudentService iStudentService;
    @Autowired
    public void constructor(IStudentService iStudentService){
        this.iStudentService = iStudentService;
    }

    @ApiOperation(value = "测试方法的Api")
    @GetMapping("/test")
    public String test(){
        return iStudentService.getStr();
    }


    @ApiOperation(value = "获取所有的学生信息")
    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents(){
        return iStudentService.getAllStudents();
    }

    @ApiOperation(value = "根据主键编码获取单独用户")
    @GetMapping("/getStudentById/{id}")
    public Student getStudentById(@PathVariable(name = "id")Integer id){
        return null;
    }

}
