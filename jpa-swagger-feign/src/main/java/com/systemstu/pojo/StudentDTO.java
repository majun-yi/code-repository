package com.systemstu.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

@ApiModel("/学生入参模型")
public class StudentDTO {

    @ApiModelProperty("姓名")
    @NotEmpty(message = "请输入姓名")
    private String name;

    @ApiModelProperty("性别")
    @NotEmpty(message = "请输入性别")
    private String sex;
}
