package com.boot.boot_cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
/**
 * 开启缓存
 */
@EnableCaching
/**
 * 开启事务
 */
@EnableTransactionManagement
public class BootCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootCacheApplication.class, args);
    }

}
