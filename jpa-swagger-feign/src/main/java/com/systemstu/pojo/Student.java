package com.systemstu.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity(name = "student")
@Setter
@Getter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "sex")
    private String sex;
}
