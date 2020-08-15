package com.ioc.ioc_class.entity;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2020/8/15 17:46
 */
public class User {
    private Student student;


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public User() {
    }

    public User(Student student) {
        this.student = student;
    }
}
