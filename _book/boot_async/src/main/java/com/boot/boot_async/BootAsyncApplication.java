package com.boot.boot_async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync//开启异步
public class BootAsyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootAsyncApplication.class, args);
    }

}
