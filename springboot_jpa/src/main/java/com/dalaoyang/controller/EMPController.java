package com.dalaoyang.controller;

import com.dalaoyang.entity.*;
import com.dalaoyang.service.IEMPService;
import com.dalaoyang.service.IStuService;
import com.dalaoyang.service.ITeaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "人员管理")
@RestController
@RequestMapping("/ems")//emp manage system
public class EMPController {


    @Autowired
    private IEMPService iempService;

    @Autowired
    private IStuService iStuService;

    @Autowired
    private ITeaService iTeaService;

    @ApiOperation(value = "获取分页和条件查询")
    @PostMapping("/getPageAndCriteria/{size}/{page}")
    public PageVO<User> getPage(@Valid @RequestBody(required = false) PageCriteriaDTP queryDto, @PathVariable Integer size, @PathVariable Integer page) {
        return iempService.findByPage(queryDto,size,page);
    }


    @ApiOperation(value = "查询学生信息")
    @GetMapping("/getStuInfo/{ID}")
    public StudentEntity getStu(@PathVariable(value = "ID") Integer ID){
        return iStuService.findByID(ID);
    }


    @ApiOperation(value = "查询老师信息")
    @GetMapping("/getTeaInfo/{ID}")
    public TeacherVO getTea(@PathVariable(value = "ID") Integer ID){
        return iTeaService.findByID(ID);
    }

    @ApiOperation(value = "测试枚举打印")
    @GetMapping("/test/{id}")
    public void test(@PathVariable(value = "id") Integer id)throws Exception{
        iTeaService.test(id);
    }


    @ApiOperation(value = "根据名称查询学生信息")
    @GetMapping("/getStuByName")
    public StudentVO getStu(String name){
        return iStuService.findByName(name);
    }


    @ApiOperation(value = "添加学生信息")
    @PostMapping("/addStu")
    public Integer addStu(@RequestBody StudentEntity entity){
        return iStuService.save(entity);
    }

    @ApiOperation(value = "根据删除状态查询学生信息")
    @GetMapping("/getStuByStatus")
    public StudentVO getStuByStatus(Integer id){
        return iStuService.findByStatus();
    }
    @ApiOperation(value = "SQL方式获取学生集合")
    @GetMapping("/getStuList")
    public List<StudentVO> getStuList(){
        return iStuService.findBySQL();
    }
}
