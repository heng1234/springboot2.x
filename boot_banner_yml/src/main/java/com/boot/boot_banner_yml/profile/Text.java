package com.boot.boot_banner_yml.profile;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author : kaifa
 * create at:  2019-10-18  14:36
 * @description: springboot读取配置文件信息
 */
//配置文件前缀
@ConfigurationProperties(prefix="val")
// 获取外部的配置文件文件,需要指定配置文件的路径
@PropertySource(
        value = "classpath:val.properties",
        encoding = "utf-8"
)
@Component
//lombok
@Data
public class Text implements Serializable {
    /**
     * 这里不需要写@value注解了  这里的名字与配置文件一致
     */
    private String text;

}
