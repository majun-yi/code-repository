package com.test.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@Entity(name = "teacher")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class TeacherEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    /**
     * 用户名
     */
    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;
    @JsonIgnore
    /**
     * 第一种方式，直接通过mappedBy 指定维护权（多的一方/从表维护）
     */
    //@OneToMany(targetEntity = StudentEntity.class,mappedBy = "teacherEntity",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    /**
     * 第二种方式，通过joinColumn指定联系字段（外键）进行关联，name为从表的数据字段名，referencedColumnName为本实体的主键
     */
    @OneToMany(targetEntity = StudentEntity.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="teacher_id",referencedColumnName = "id")


    private List<StudentEntity> studentEntityList;

}
