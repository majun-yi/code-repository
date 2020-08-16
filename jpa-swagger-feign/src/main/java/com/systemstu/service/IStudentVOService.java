package com.systemstu.service;

import com.systemstu.pojo.dto.AddStuDTO;
import com.systemstu.pojo.dto.StudentDTO;
import com.systemstu.pojo.vo.PageVO;
import com.systemstu.pojo.vo.StudentVO;
import java.util.List;

public interface IStudentVOService {

    String getStr();

    List<StudentVO> getAllStudents();

    StudentVO getStudentByID(Integer id);

    /**
     * @Description: 通过ID获取信息:方式二
     * @Author: mjy
     * @CreateDate: 2020/8/15 13:36
     * @Params id
     */
    StudentVO getStudentByID2(Integer id);

    PageVO pageQuery(StudentDTO student, Integer pageNum, Integer pageSize);

    Integer addStudent(AddStuDTO student);

    Integer deleteStudentReally(Integer id);

    Integer deleteStudent(Integer id);

    Integer updateStudent(StudentDTO student);
}
