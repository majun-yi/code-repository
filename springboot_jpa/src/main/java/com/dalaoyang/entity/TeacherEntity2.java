/*
package com.dalaoyang.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

//@Data
@Setter
@Getter
@Entity(name = "teacher")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class TeacherEntity2 implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    */
/**
     * 用户名
     *//*

    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "teacherEntity")
   // @JsonIgnore
    //TODO 这里有问题,会产生对象相互迭代,致使栈溢出
   // @JsonIgnoreProperties(value = {"studentEntityList"})//中断集合,防止栈溢出
    private List<StudentEntity> studentEntityList;
}
*/
