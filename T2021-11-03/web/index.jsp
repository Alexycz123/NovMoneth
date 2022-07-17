<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/11/3
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>




    <form action="${pageContext.request.contextPath}/download" method="post">
      <input type="text" name="fileName" placeholder="请输入文件名">
      <input type="submit" value="下载图片">
    </form>



  </body>
</html>
