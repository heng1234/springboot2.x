package com.boot.inte_filter_servlet.filter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : kaifa
 * create at:  2019-11-05  18:23
 * @description: 测试过滤器
 */
@RestController
@RequestMapping("filter")
public class FilterController {
    @RequestMapping("filterTest")
    public String filterTest(){
        return "this filter";
    }
}
