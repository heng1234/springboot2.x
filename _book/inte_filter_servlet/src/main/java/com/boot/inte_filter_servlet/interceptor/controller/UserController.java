package com.boot.inte_filter_servlet.interceptor.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : kaifa
 * create at:  2019-11-05  11:08
 * @description: 测试拦截器
 */
@RestController
@RequestMapping("user")
public class UserController {

    @RequestMapping("init")
    public String init(){
        return "init";
    }


    @RequestMapping("notInit")
    public String notInit(){
        return "notInit";
    }
}
