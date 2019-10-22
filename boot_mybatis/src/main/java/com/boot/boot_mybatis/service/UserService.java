package com.boot.boot_mybatis.service;

import com.boot.boot_mybatis.entity.User;
import com.boot.boot_mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : kaifa
 * create at:  2019-10-22  10:10
 * @description: user 业务层
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    /**
     * 查询所有用户
     * @return
     */
   public List<User> selectListAll(){
        return userMapper.selectListAll();
    }
}
