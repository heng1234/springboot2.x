package com.boot.inte_filter_servlet.servlet.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : kaifa
 * create at:  2019-11-06  09:50
 * @description: servlet
 */
@WebServlet(urlPatterns = "/user")
@Slf4j
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       log.info("user--doGet方法");
        resp.setHeader("Content-Type","text/html;charset=UTF-8");
        resp.getOutputStream().write("user--doGet方法".getBytes("UTF-8"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req, resp);
    }
}
