package com.ycz.servlet;/*
 @author ycz
 @date 2021-11-03-18:34
*/

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/download")
public class DownLoadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
        //
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String fileName = request.getParameter("fileName");
        ServletContext servletContext=this.getServletContext();
        String realPath=servletContext.getRealPath("/img/"+fileName);
        File file=new File(realPath);

        if (file.exists()){

            //3.设置response的响应头
            //3.1设置响应头类型：content-type
            String mimeType = servletContext.getMimeType(fileName);//获取文件的mime类型
            response.setHeader("content-type",mimeType);
            //3.2设置响应头打开方式:content-disposition


            response.setHeader("content-disposition","attachment;filename="+
                    URLEncoder.encode(fileName,"utf-8"));
            FileInputStream fin=new FileInputStream(file);

            ServletOutputStream out= response.getOutputStream();
            byte[] bytes=new byte[1024];
            int len;
            while ((len=fin.read(bytes))!=-1){
                out.write(bytes,0,len);
            }
            fin.close();


        }else {
            response.getWriter().println("图片不存在，请重新输入");
        }

    }
}
