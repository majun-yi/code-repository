package com.systemstu.pojo.vo;

import com.systemstu.pojo.Student;

/**
 * @Description 学生类的出参 实体:
 * @Author Administrator
 * @Date 2020/8/16 8:49
 */
public class StudentVO {
    private Integer id;
    private String name;
    private String sex;

    public StudentVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public StudentVO(Integer id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public StudentVO(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.sex = student.getSex();
    }
}
