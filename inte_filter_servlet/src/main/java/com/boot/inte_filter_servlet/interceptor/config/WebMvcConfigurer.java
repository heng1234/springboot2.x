package com.boot.inte_filter_servlet.interceptor.config;


import com.boot.inte_filter_servlet.interceptor.init.UserInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

/**
 * @author : kaifa
 * create at:  2019-11-04  18:18
 * @description: 拦截器配置
 */
@Configuration
public class WebMvcConfigurer implements org.springframework.web.servlet.config.annotation.WebMvcConfigurer {

    @Autowired
    private UserInterceptor userInterceptor;

    //配置拦截的资源以及放行的资源
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * 拦截器按照顺序执行
         */
       //拦截Controller所有 /*/**   userInterceptor是定义的拦截器
        registry.addInterceptor(userInterceptor)
                .addPathPatterns("/**")
                //不拦截url
                .excludePathPatterns("/user/notInit")
                //放行静态资源
                .excludePathPatterns("/img/**","/css/**","/fonts/**","/js/**");

    }

    //配置静态资源的位置
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    }

}
