package com.boot.boot_banner_yml.profile;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author : kaifa
 * create at:  2019-10-18  14:36
 * @description: springboot读取配置文件信息
 */
//配置文件前缀
@ConfigurationProperties(prefix="lv")
@Component
//lombok
@Data
public class Account implements Serializable {
    /**
     * 这里不需要写@value注解了  这里的名字与配置文件一致
     */
    private String name;

    private String password;
}
