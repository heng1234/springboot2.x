package com.boot.boot_cache.mapper;

import com.boot.boot_cache.entity.User;

import java.util.List;

/**
 * @author : kaifa
 * create at:  2019-10-22  10:10
 * @description: user mapper接口
 */
public interface UserMapper {

    /**查询所有用户*/
    List<User> selectListAll();

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    User findUserById(Integer id);
}
