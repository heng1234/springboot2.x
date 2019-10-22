package com.boot.boot_log_aop.controller;

import com.boot.boot_log_aop.annotation.Log;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : kaifa
 * create at:  2019-10-22  17:33
 * @description: 测试日志切面controller
 */
@RestController
@RequestMapping("log")
public class LogController {

    @RequestMapping("findlog")
    @Log("hello log")
    public String log1(HttpServletRequest request){
        return "hello log";
    }

    @Log("测试log")
    @RequestMapping("findlogId")
    public String log2(HttpServletRequest request,String name){
        return "hello "+name;
    }
}
