package com.boot.boot_log_aop.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author : kaifa
 * create at:  2019-10-22  10:03
 * @description: mybatis配置类
 */
@Configuration
@MapperScan("com.boot.boot_log_aop.mapper")
public class MybatisConfig {
}
