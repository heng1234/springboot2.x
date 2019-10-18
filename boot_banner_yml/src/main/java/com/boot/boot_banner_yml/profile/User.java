package com.boot.boot_banner_yml.profile;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author : kaifa
 * create at:  2019-10-18  14:36
 * @description: springboot读取配置文件信息
 */
//lombok
@Data
@Component
public class User implements Serializable {

    @Value("${lv.name}")
    private String name;

    @Value("${lv.password}")
    private String password;
}
