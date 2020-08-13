/*
package com.dalaoyang.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

//@Data
@Setter
@Getter
@Entity(name = "student")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class StudentEntity2 implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String sex;

    @Column(name = "name")
    private String name;

    @Column(name = "")
    private Integer teacherId;

//    @ManyToOne(targetEntity = TeacherEntity.class,cascade = CascadeType.ALL)
    @ManyToOne()
    @JoinColumn(name="teacherId",updatable = false,insertable = false)
    private TeacherEntity teacherEntity;


    public Integer getId() {
        return id;
    }

    public String getSex() {
        return sex;
    }

    public String getName() {
        return name;
    }

    public Integer getTeacherId() {
        return teacherId;
    }
}
*/
