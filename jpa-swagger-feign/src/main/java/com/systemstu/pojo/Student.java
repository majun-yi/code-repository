package com.systemstu.pojo;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity //说明这个了是entity实体类
@Table(name = "student")//指定表名
//lombox提供的setter和getter方法
@Setter
@Getter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(generator = "JDBC")
    private Integer id;
    @Column(name = "name")
    private String name;

    @Column(name = "sex")
    private String sex;
}
