package com.ycz.servlet;/*
 @author ycz
 @date 2021-11-08-16:37
*/

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获得请求的路径
        //1.1  根据请求的路径  获得具体方法名
        String requestUri = req.getRequestURI();
        System.out.println("请求的路径是:"+requestUri);
        //1.2 获得对应的servlet的字节码   this
        Class servletClass = this.getClass();
        //2.根据方法名找到对应的方法
        //2.2 截取字符串获得方法名
        String methodName = requestUri.substring(requestUri.lastIndexOf("/") + 1);
        System.out.println("获得方法名是:"+methodName);
        //3. 获得类对应的成员方法
        try {
            Method method =servletClass.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            //调用方法
            method.setAccessible(true);
            method.invoke(this,req,resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

