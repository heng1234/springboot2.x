package com.boot.boot_mybatis.mapper;

import com.boot.boot_mybatis.entity.User;

import java.util.List;

/**
 * @author : kaifa
 * create at:  2019-10-22  10:10
 * @description: user mapper接口
 */
public interface UserMapper {

    /**查询所有用户*/
    List<User> selectListAll();
}
