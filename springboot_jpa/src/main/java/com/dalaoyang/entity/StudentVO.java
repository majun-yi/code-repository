package com.dalaoyang.entity;

import lombok.*;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2020/8/12 9:03
 */
@Setter
@Getter
public class StudentVO {

    public StudentVO() {
    }

    private Integer id;

    private String sex;

    private String name;

    private Integer teacherId;

    private TeacherEntity teacherEntity;

    private Integer isDelete;
    public StudentVO(Integer id, String sex, String name, Integer teacherId, TeacherEntity teacherEntity) {
        this.id = id;
        this.sex = sex;
        this.name = name;
        this.teacherId = teacherId;
        this.teacherEntity = teacherEntity;
    }

    public StudentVO(StudentEntity studentEntity){
        this.id = studentEntity.getId();
        this.sex = studentEntity.getSex();
        this.name = studentEntity.getName();
        this.isDelete = studentEntity.getIsDelete();
        this.teacherEntity = studentEntity.getTeacherEntity();
    }

}
