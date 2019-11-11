package com.boot.boot_resoure.controller;

import com.boot.boot_resoure.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : kaifa
 * create at:  2019-10-16  17:02
 * @description: lombok测试
 */
@RestController
@RequestMapping("lombok")
public class LombokController {

    /**
     * 测试lombok方法
     * @return
     */
    @GetMapping("/testLombok.html")
    public String testLombok(){
        //实体类没有写setter  getter方法 还有toString方法
        //都是lombok自动为我们创建的
        User user = new User();
        user.setName("name");
        user.setPassword("123456");
        return "lombok:---"+user.toString();
    }
}
