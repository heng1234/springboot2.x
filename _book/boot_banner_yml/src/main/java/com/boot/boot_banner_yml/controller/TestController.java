package com.boot.boot_banner_yml.controller;

import com.boot.boot_banner_yml.profile.Account;
import com.boot.boot_banner_yml.profile.Text;
import com.boot.boot_banner_yml.profile.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : kaifa
 * create at:  2019-10-18  14:47
 * @description: 测试读取配置文件
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private User user;
    @Autowired
    private Account account;
    @Autowired
    private Text text;
    /**
     * @Value 读取application.yml数据
     * @return
     */
    @RequestMapping("user")
    public User readFileUser(){
        return user;
    }
    /**
     * 读取application.yml数据
     * 读取前缀
     * @return
     */
    @RequestMapping("account")
    public Account readFileAccount(){
        return account;
    }

    /**
     * 自定义val.yml读取文件
     * @return
     */
    @RequestMapping("text")
    public Text readFileText(){
        return text;
    }
}
