package com.boot.boot_thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : kaifa
 * create at:  2019-10-23  13:55
 * @description: thymeleaf 控制层
 */
@Controller
@RequestMapping("tf")
public class ThyeleafController {


    @RequestMapping("index.do")
    public String toIndex(HttpServletRequest request, String name, Model model){
        model.addAttribute("name",name);
        model.addAttribute("href","https://blog.csdn.net/qq_39313596/article/details/82147626");
        return "index";
    }
}
