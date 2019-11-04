package com.boot.boot_cache.controller;

import com.boot.boot_cache.entity.User;
import com.boot.boot_cache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : kaifa
 * create at:  2019-10-22  10:16
 * @description: user controller
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询所有用户
     * @return
     */
    @RequestMapping("userList.do")
    List<User> selectListAll(){
        return userService.selectListAll();
    }


    /**
     * 修改用户
     * @return
     */
    @RequestMapping("updateUser.do")
    String  updateUser(User user){
         userService.updateUser(user);
         return "success";
    }

    /**
     * 根据id查询
     * @return
     */
    @RequestMapping("findUserById.do")
    User findUserById(Integer id){
        return userService.findUserById(id);
    }
}
