package com.systemstu.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

@ApiModel(value = "学生入参模型-addStuDTO")
public class AddStuDTO {
    @ApiModelProperty(value = "姓名")
    @NotEmpty(message = "请输入姓名")
    private String name;

    @ApiModelProperty(value = "性别")
    @NotEmpty(message = "请输入性别")
    private String sex;

    public AddStuDTO() {
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

    public AddStuDTO(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }


}
