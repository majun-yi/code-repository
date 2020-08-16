package com.systemstu.controller;

import com.systemstu.pojo.dto.AddStuDTO;
import com.systemstu.pojo.dto.StudentDTO;
import com.systemstu.pojo.vo.PageVO;
import com.systemstu.pojo.vo.StudentVO;
import com.systemstu.service.IStudentVOService;
import com.systemstu.service.IStudentVOService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

/**
 * @Description 通过DTO(入参)和VO(出参)的方式进行处理
 * @Author Administrator
 * @Date 2020/8/16 8:43
 */
@Api(tags = "学生信息--规范式处理")
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentVOService IStudentVOService;

    @ApiOperation(value = "获取所有的学生信息")
    @GetMapping("/getAllStudents")
    public List<StudentVO> getAllStudents(){
        return IStudentVOService.getAllStudents();
    }

    @ApiOperation(value = "根据主键编码获取单独用户-方式一")
    @GetMapping("/getStudentById/{id}")
    public StudentVO getStudentById(@PathVariable(name = "id")Integer id){
        return IStudentVOService.getStudentByID(id);
    }

    @ApiOperation(value = "根据主键编码获取单独用户---Optional<Student>方式")
    @GetMapping("/getStudentById2/{id}")
    public StudentVO getStudentById2(@PathVariable(name = "id")Integer id){
        return IStudentVOService.getStudentByID2(id);
    }

    @ApiOperation(value ="分页查询")
    @PostMapping("/pageQuery/{pageNum}/{pageSize}")
    public PageVO pageQuery(@RequestBody StudentDTO studentvo, Integer pageNum, Integer pageSize){
        return IStudentVOService.pageQuery(studentvo,pageNum,pageSize);
    }

    @ApiOperation(value = "增加学生")
    @PostMapping("/addStudent")
    public Integer addStudent(@RequestBody AddStuDTO student){
        return IStudentVOService.addStudent(student);
    }
    @ApiOperation(value = "删除学生(真正的删除)")
    @DeleteMapping("/deleteStudentReally/{id}")
    public Integer deleteStudentReally(@PathVariable(name = "id")Integer id) throws Exception {
        return IStudentVOService.deleteStudentReally(id);
    }
    @ApiOperation(value = "删除学生(逻辑删除)")
    @DeleteMapping("/deleteStudent/{id}")
    public Integer deleteStudent(@PathVariable(name = "id") Integer id){
        return IStudentVOService.deleteStudent(id);
    }
    @ApiOperation(value = "修改学生信息")
    @PutMapping("/updateStudent")
    public Integer updateStudent(@RequestBody StudentDTO student){
        return IStudentVOService.updateStudent(student);
    }

}
