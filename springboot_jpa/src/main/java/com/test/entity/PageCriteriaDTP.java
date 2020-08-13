package com.test.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.Date;

/**
 * 查询条件
 */
@Data
@ApiModel("人员管理-分页查询信息-请求参数")
public class PageCriteriaDTP {

    /**
     * 用户名(支持模糊查询)
     */
    @ApiModelProperty(value = "用户名(支持模糊查询)")
    private String userName;
    @ApiModelProperty(value = "性别")
    @Min(1)
    @Max(2)
    private String sex;
    @ApiModelProperty(value = "出生日期", name = "时间日期格式不正确")
    private ArrayList<Date> birthday;
}
