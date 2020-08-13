package com.dalaoyang.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Entity(name = "student")
@Getter
@Setter
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class StudentEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String sex;

    @Column(name = "name")
    private String name;

    @Column(name = "isDelete")
    private Integer isDelete;
    /**
     * 配置多的一方
     */
    @ManyToOne(targetEntity = TeacherEntity.class,cascade = {CascadeType.MERGE,CascadeType.REFRESH},optional = false)
    @JoinColumn(name = "teacher_id",insertable = false,updatable = false)
    private TeacherEntity teacherEntity;

}
