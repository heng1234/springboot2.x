package com.boot.inte_filter_servlet.filter.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author : kaifa
 * create at:  2019-11-05  17:59
 * @description: 使用拦截器注解版
 */
@Order(1)//优先级
@WebFilter(filterName = "userfilter",urlPatterns = "/*")
public class UserWebFilter implements Filter {

    /**
     * log日志
     */
    Logger log= LoggerFactory.getLogger(this.getClass());

    /**
     * 该方法由 web 容器调用,以指示 Filter 已经投入使用。servlet容器在实例化过滤器之后调用init方法一次。在要求过滤器执行任何过滤工作之前，init方法必须成功完成。当 init 方法出现以下情况时 Filter 将不生效:
     * a.抛出了 ServletException 异常;
     * b.在一段时间内没有返回结果(超时了)
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        log.info("调用init()方法初始化实例，在项目启动时候调用一次");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String requestURI = request.getRequestURI();
        StringBuffer requestURL = request.getRequestURL();
        log.info("requestURI:" +requestURI+" "+"requestURL:"+requestURL);
        log.info("每一请求只调用方法的doFilter()进行真正的过滤处理，每次发出请求都会调用");
        filterChain.doFilter(request, servletResponse);
    }

    @Override
    public void destroy() {
        log.info("停止服务器调用destroy()方法，销毁实例，释放资源，项目停止时销毁一次");
    }
}
