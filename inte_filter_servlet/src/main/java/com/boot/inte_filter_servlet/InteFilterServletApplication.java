package com.boot.inte_filter_servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class InteFilterServletApplication {

    public static void main(String[] args) {
        SpringApplication.run(InteFilterServletApplication.class, args);
    }

}
