package com.boot.boot_resoure.entity;

import lombok.Data;

/**
 * @author : kaifa
 * create at:  2019-10-16  16:57
 * @description: springboot2.x集成lombok
 * 不需要写get set方法插件会为我们自动生成减少了代码量 需要在idea安装lombok插件
 * @Date包含
 * @Getter
 * @Setter
 * @ToString
 * @EqualsAndHashCode
 * 这些注解
 */
@Data
public class User {
    /**
     * name
     */
    private String name;
    /**
     * password
     */
    private String password;
}
