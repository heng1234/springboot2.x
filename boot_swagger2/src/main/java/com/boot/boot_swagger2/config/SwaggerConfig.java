package com.boot.boot_swagger2.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static com.google.common.collect.Lists.newArrayList;

/**
 *
 * 一般引入类的方式：import java.lang.Math.*;
 * <p>
 * 静态引入类的方式：import static java.lang.Math.*;
 * <p>
 * 区别在于：
 * 一般引入需要使用 ClassName.method(); 的方式去调用类中的静态方法；
 * 而静态引入后，直接使用 method(); 即可使用静态方法。
 */
/**
 * @author : kaifa
 * create at:  2019-11-13  11:01
 * @description: swagger配置类
 */
// @Configuration 是告诉 Spring Boot 需要加载这个配置类
@Configuration
//@EnableSwagger2 是启用 Swagger2
@EnableSwagger2
public class SwaggerConfig {
    /**
     * Java 配置
     * Springfox 提供了一个 Docket 对象，让我们可以灵活的配置 Swagger 的各项属性。
     * 下面我们新建一个 SwaggerConfig.java 类，并增加如下内容:
     * @return
     */
    @Bean
    @Profile({"dev","test"})// 设置 dev test 环境开启
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.boot.boot_swagger2.controller"))

                /**
                 * 在 Docket 上增加筛选。Docket 类提供了 apis() 和 paths()两 个方法来帮助我们在不同级别上过滤接口：
                 * apis()：这种方式我们可以通过指定包名的方式，让 Swagger 只去某些包下面扫描。
                 * paths()：这种方式可以通过筛选 API 的 url 来进行过滤。
                 * 在集成 Swagger2 的章节中我们这两个方法指定的都是扫描所有，没有指定任何过滤条件。
                 * 如果我们在我们修改之前定义的 Docket 对象的 apis() 方法和 paths() 方法为下面的内容，
                 * 那么接口文档将只会展示 /userinfo/add 和 /user/** user下的所有接口 。
                 *
                 * 使用 Docket 配置接口筛选
                 */

                .paths(Predicates.or(PathSelectors.ant("/userinfo/add"),
                        PathSelectors.ant("/user/**")))
                .build()
                /**
                 * 文档信息配置，Swagger 还支持设置一些文档的版本号、联系人邮箱、网站、版权、开源协议等等信息，
                 * 但与上面几条不同的是这些信息不是通过注解配置，
                 * 而是通过创建一个 ApiInfo 对象，并且使用 Docket.appInfo() 方法来设置，
                 * 我们在 SwaggerConfig.java 类中新增如下内容即可。
                 * @return
                 */
                .apiInfo(apiInfo())

                /**
                 * 自定义响应消息
                 * Swagger 允许我们通过 Docket 的 globalResponseMessage()
                 * 方法全局覆盖 HTTP 方法的响应消息，但是首先我们得通过 Docket 的 useDefaultResponseMessages
                 * 方法告诉 Swagger 不使用默认的 HTTP 响应消息，
                 * 假设我们现在需要覆盖所有 GET 方法的 500 和 403 错误的响应消息，
                 * 我们只需要在 SwaggerConfig.java 类中的 Docket Bean 下添加如下内容：
                 * 添加如上面的代码后，您会发现在 SwaggerUI
                 * 页面展示的所有 GET 类型请求的 403 以及 500 错误的响应消息都变成了我们自定义的内容。
                 */
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET,  newArrayList(
                        new ResponseMessageBuilder()
                                .code(500)
                                .message("服务器发生异常")
                                .responseModel(new ModelRef("Error"))
                                .build(),
                        new ResponseMessageBuilder()
                                .code(403)
                                .message("资源不可用")
                                .build()
                ));
    }



    private ApiInfo apiInfo() {
        return new ApiInfo(
                "springboot项目集成Swagger2实例文档",
                "我的博客：https://blog.csdn.net/qq_39313596，欢迎大家访问。",
                "API V1.0",
                "hlvy",
                new Contact("springboot2.x教程文档", "https://loren123.gitbook.io/hlvy/", "xiaoluoheng@foxmail.com"),
                "github地址", "https://github.com/heng1234", Collections.emptyList());
        /**
         * emptyList()方法的使用
         * 通过java.util.Collections.emptyList()方法的相关源码可以得知它实际上就是返回了一个空的List，但是这个List和我们平时常用的那个List是不一样的。这个方法返回的List是Collections类的一个静态内部类，它继承AbstractList后并没有实现add()、remove()等方法，因此这个返回值List并不能增加删除元素。
         * 既然这个List不能进行增删操作，那么它有何意义呢？
         * 这个方法主要目的就是返回一个不可变的列表，使用这个方法作为返回值就不需要再创建一个新对象，可以减少内存开销。并且返回一个size为0的List，调用者不需要校验返回值是否为null，所以建议使用这个方法返回可能为空的List。
         * emptySet()、emptyMap()方法同理。
         */






    }

}
