package com.systemstu.pojo;

import lombok.Data;

import javax.persistence.*;


@Entity(name = "sys_student")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;
}
