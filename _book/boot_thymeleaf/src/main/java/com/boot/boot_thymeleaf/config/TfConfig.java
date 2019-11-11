package com.boot.boot_thymeleaf.config;

import com.boot.boot_thymeleaf.tf.ThSysDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : kaifa
 * create at:  2019-10-24  16:11
 * @description: tf bean
 */
@Configuration
public class TfConfig {
    @Bean
    public ThSysDialect thSysDialect() {
        return new ThSysDialect();
    }
}
