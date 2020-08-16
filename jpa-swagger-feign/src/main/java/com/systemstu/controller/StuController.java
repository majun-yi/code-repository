package com.systemstu.controller;

import com.systemstu.pojo.Student;
import com.systemstu.service.IStudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Api(tags = "学生单模块管理" )
@RestController
public class StuController {

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

    @ApiOperation(value = "根据主键编码获取单独用户-方式一")
    @GetMapping("/getStudentById/{id}")
    public Student getStudentById(@PathVariable(name = "id")Integer id){
        return iStudentService.getStudentByID(id);
    }

    @ApiOperation(value = "根据主键编码获取单独用户---Optional<Student>方式")
    @GetMapping("/getStudentById2/{id}")
    public Optional<Student> getStudentById2(@PathVariable(name = "id")Integer id){
        return iStudentService.getStudentByID2(id);
    }

    @ApiOperation(value ="分页查询")
    @PostMapping("/pageQuery/{pageNum}/{pageSize}")
    public Page<Student> pageQuery(@RequestBody Student student, Integer pageNum, Integer pageSize){
        return iStudentService.pageQuery(student,pageNum,pageSize);
    }

    @ApiOperation(value = "增加学生")
    @PostMapping("/addStudent")
    public Integer addStudent(@RequestBody Student student){
        return iStudentService.addStudent(student);
    }
    @ApiOperation(value = "删除学生(真正的删除)")
    @DeleteMapping("/deleteStudentReally/{id}")
    public Integer deleteStudentReally(@PathVariable(name = "id")Integer id){
        return iStudentService.deleteStudentReally(id);
    }
    @ApiOperation(value = "删除学生(逻辑删除)")
    @DeleteMapping("/deleteStudent/{id}")
    public Integer deleteStudent(@PathVariable(name = "id") Integer id){
        return iStudentService.deleteStudent(id);
    }
    @ApiOperation(value = "修改学生信息")
    @PutMapping("/updateStudent")
    public Integer updateStudent(@RequestBody Student student){
        return iStudentService.updateStudent(student);
    }
}
