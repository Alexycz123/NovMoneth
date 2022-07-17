<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/11/8
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>a</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
</head>
<body>
<div align="center">
    <a href="${pageContext.request.contextPath}/user/list" style="text-decoration:none;font-size:33px">查询所有用户信息
    </a><hr/>
    <h2>${loginName} 欢迎您，靓${gender123}</h2>
</div>
</body>
</html>
