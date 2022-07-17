package com.ycz.servlet;/*
 @author ycz
 @date 2021-11-18-11:01
*/

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/login")
public class AjaxServlet extends HttpServlet {
    private final ObjectMapper objectMapper=new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String username=request.getParameter("username");
        String password=request.getParameter("password");
        System.out.println(username+password);

        Map<String,Object> result=new HashMap<>();

        if (username.equals("admin") && password.equals("123456")){
            result.put("code",200);
            result.put("msg","操作成功");
            response.getWriter().print(objectMapper.writeValueAsString(result));
        }else {
            result.put("code",4000001);
            result.put("msg","用户名或密码错误");
            response.getWriter().print(objectMapper.writeValueAsString(result));
        }



    }
}
