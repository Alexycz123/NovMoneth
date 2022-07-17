package com.ycz.filter;/*
 @author ycz
 @date 2021-11-15-9:15
*/

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("拦截器初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("拦截了");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("后置拦截");


    }

    @Override
    public void destroy() {
        System.out.println("销毁了");
    }
}
