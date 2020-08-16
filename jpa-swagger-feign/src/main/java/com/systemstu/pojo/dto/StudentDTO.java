package com.systemstu.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

@ApiModel(value = "学生入参模型")
public class StudentDTO {
    @ApiModelProperty(value = "主键编码")
    @NotEmpty(message = "请传入主键编码")
    private Integer id;

    @ApiModelProperty(value = "姓名")
    @NotEmpty(message = "请输入姓名")
    private String name;

    @ApiModelProperty(value = "性别")
    @NotEmpty(message = "请输入性别")
    private String sex;

    public StudentDTO() {
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

    public StudentDTO(Integer id, String name,String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }


}
