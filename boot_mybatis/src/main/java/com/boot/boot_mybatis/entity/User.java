package com.boot.boot_mybatis.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author : kaifa
 * create at:  2019-10-18  18:30
 * @description: user类
 */
@Data
public class User {

    /**
     * id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;
    /**
     * 创建时间
     */
    private Date createTime;
}
