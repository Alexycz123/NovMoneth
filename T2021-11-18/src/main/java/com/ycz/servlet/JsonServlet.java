package com.ycz.servlet;/*
 @author ycz
 @date 2021-11-18-16:24
*/

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ycz.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/json")
public class JsonServlet extends HttpServlet {

    private final ObjectMapper objectMapper=new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        User user=new User(1,"admin","123456","深圳");

        response.getWriter().write(objectMapper.writeValueAsString(user));

    }
}
