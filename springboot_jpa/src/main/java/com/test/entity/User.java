package com.test.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "user")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 出生日期
     */

    private Date birthday;
    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;
    /**
     * 部门id
     */
    @Column(name = "dept_id")
    private Integer deptId;
    /**
     * 创建人id
     */
    @Column(name = "operator_id")
    private Integer operatorId;
    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;
    /**
     * 修改人id
     */
    @Column(name = "modifier_id")
    private Integer modifierId;
    /**
     * 是否删除
     */
    @Column(name = "is_delete")
    private Boolean isDelete;

}
