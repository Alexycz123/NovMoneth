package com.ycz.controller;/*
 @author ycz
 @date 2021-11-01-10:34
*/

import com.ycz.mapper.UserMapper;
import com.ycz.pojo.User;
import com.ycz.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(value = "/login.do",loadOnStartup = 1)
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doPost(req, resp);
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String code=req.getParameter("code");

        HttpSession session = req.getSession();
        StringBuilder code1 = (StringBuilder) session.getAttribute("code");

        System.out.println(code);
        System.out.println(password);
        System.out.println(username);
        System.out.println(code.equals(code1.toString()));
        if (!(code.equals(code1.toString()))){
            resp.getWriter().println( "code error");
        }else {
            User user=new User();
            user.setName(username);
            user.setPwd(password);
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user1 = mapper.selectById_pwd(user);
            System.out.println(user1==null?"为空":"不为空");
            if (user1!=null){
                ServletOutputStream outputStream = resp.getOutputStream();
                outputStream.write("成功".getBytes(StandardCharsets.UTF_8));
            }else {
                resp.getWriter().println("error");
            }
        }



    }
}
