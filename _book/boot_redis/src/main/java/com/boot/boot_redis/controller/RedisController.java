package com.boot.boot_redis.controller;

import com.boot.boot_redis.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : kaifa
 * create at:  2019-10-28  14:22
 * @description: 测试redis
 */
@RestController
@RequestMapping("redis")
public class RedisController {

    @Autowired
    private RedisUtil redisUtil;

    final String key = "rdsname";
    @RequestMapping("set")
    public String setKey(String name){
        redisUtil.set(key,name,7200);
        return "success";
    }

    @RequestMapping("get")
    public String getKey(){
      if (redisUtil.hasKey(key))
          return redisUtil.get(key) + "";

      return "";

    }
}


