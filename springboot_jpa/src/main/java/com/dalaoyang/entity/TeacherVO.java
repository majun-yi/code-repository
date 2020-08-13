package com.dalaoyang.entity;

import lombok.*;
import java.util.List;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2020/8/12 9:03
 */

@Getter
@Setter
public class TeacherVO {

    private Integer id;

    private String name;

    private String address;

    private List<StudentEntity> studentEntityList;

    public TeacherVO (TeacherEntity teacherEntity){
        this.id =teacherEntity.getId();
        this.name = teacherEntity.getName();
        this.address = teacherEntity.getAddress();
        this.studentEntityList = teacherEntity.getStudentEntityList();
    };

}
