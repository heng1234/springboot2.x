package com.boot.inte_filter_servlet.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : kaifa
 * create at:  2019-11-06  09:57
 * @description: 监听器session
 *
 *
 * */
@Slf4j
@WebListener
public class MyListener implements HttpSessionListener {
    private AtomicInteger onLineCount = new AtomicInteger(0);
/**
 *  ServletContextListener -- 监听servletContext对象的创建以及销毁
 *
 *         contextInitialized(ServletContextEvent arg0)   -- 创建时执行
 *
 *         contextDestroyed(ServletContextEvent arg0)  -- 销毁时执行
 *
 *  HttpSessionListener  -- 监听session对象的创建以及销毁
 *
 *       sessionCreated(HttpSessionEvent se)   -- 创建时执行
 *
 *       sessionDestroyed(HttpSessionEvent se) -- 销毁时执行
 *
 *       ServletRequestListener -- 监听request对象的创建以及销毁
 *
 *         requestInitialized(ServletRequestEvent sre) -- 创建时执行
 *
 *        requestDestroyed(ServletRequestEvent sre) -- 销毁时执行
 *
 *  ServletContextAttributeListener  -- 监听servletContext对象中属性的改变
 *
 *         attributeAdded(ServletContextAttributeEvent event) -- 添加属性时执行
 *
 *         attributeReplaced(ServletContextAttributeEvent event) -- 修改属性时执行
 *
 *         attributeRemoved(ServletContextAttributeEvent event) -- 删除属性时执行
 *
 *  HttpSessionAttributeListener  --监听session对象中属性的改变
 *
 *       attributeAdded(HttpSessionBindingEvent event) -- 添加属性时执行
 *
 *        attributeReplaced(HttpSessionBindingEvent event) -- 修改属性时执行
 *
 *        attributeRemoved(HttpSessionBindingEvent event) -- 删除属性时执行
 *
 *          ServletRequestAttributeListener  --监听request对象中属性的改变
 *
 *         attributeAdded(ServletRequestAttributeEvent srae) -- 添加属性时执行
 *
 *        attributeReplaced(ServletRequestAttributeEvent srae) -- 修改属性时执行
 *
 *        attributeRemoved(ServletRequestAttributeEvent srae) -- 删除属性时执行
* */
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        se.getSession().getServletContext().setAttribute("onLineCount", onLineCount.incrementAndGet());
        log.info("session初始化完成");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        log.info("session销毁");
        se.getSession().getServletContext().setAttribute("onLineCount", onLineCount.decrementAndGet());

    }
}
