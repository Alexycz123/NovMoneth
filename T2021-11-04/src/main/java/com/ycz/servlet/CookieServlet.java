package com.ycz.servlet;/*
 @author ycz
 @date 2021-11-04-17:13
*/

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
@WebServlet("/getAndSetCookie")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        Cookie[] last_dates = request.getCookies();
        for (Cookie last_date : last_dates) {
            System.out.println(last_date+"最后一次登录为"+last_date.getValue());
        }

        Cookie cookieDate=new Cookie("lastDate",
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        cookieDate.setMaxAge(60 * 60 * 24);
        response.addCookie(cookieDate);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
