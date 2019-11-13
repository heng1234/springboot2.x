package com.boot.boot_swagger2.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author : kaifa
 * create at:  2019-11-13  11:02
 * @description: 用户实体类
 *
 * 实体描述，我们可以通过 @ApiModel 和 @ApiModelProperty 注解来对我们 API 中所涉及到的对象做描述。
 */
@Data
@ApiModel("用户实体类")
public class User {

    @ApiModelProperty("用户id")
    private Integer id;

    @ApiModelProperty("用户姓名")
    private String name;

    @ApiModelProperty("用户邮箱")
    private String email;

}
