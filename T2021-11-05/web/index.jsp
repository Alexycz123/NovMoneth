<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/11/8
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>管理员登录</title>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

  </head>
  <body>
  <div class="container" style="width: 400px;">
    <h3 style="text-align: center;">管理员登录</h3>
    <form action="${pageContext.request.contextPath}/user/login" method="post">
      <div class="form-group">
        <label for="user">用户名：</label>
        <input type="text" name="username" class="form-control" id="user" placeholder="请输入用户名"/>
      </div>

      <div class="form-group">
        <label for="password">密码：</label>
        <input type="password" name="password" class="form-control" id="password" placeholder="请输入密码"/>
      </div>

      <div class="form-inline">
        <label for="vcode">验证码：</label>
        <input type="text" name="verifycode" class="form-control" id="verifycode" placeholder="请输入验证码" style="width: 120px;"/>
        <a href="javascript:refreshCode()">
          <img src="vcode" title="看不清点击刷新" id="vcode"/></a>
      </div>


      <hr/>
      <div class="form-group" style="text-align: center;">
        <input class="btn btn btn-primary" type="submit" value="登录">
      </div>

        <div class="form-group" style="text-align: center;">
            <a class="btn btn btn-primary" href="${pageContext.request.contextPath}/user/toRegister" >注册</a>
        </div>


    </form>

    <!-- 出错显示的信息框 -->
    <c:if test="${not empty loginMsg}">
    <div class="alert alert-warning alert-dismissible" role="alert">
      <button type="button" class="close" data-dismiss="alert" >
        <span>&times;</span></button>
      <strong>${loginMsg}</strong>
    </div>
    </c:if>

  </div>
  </body>


<script type="text/javascript">
  window.onload=function (){
    refreshCode()
  }
  let baseurl="${pageContext.request.contextPath}";
  //开始就发送验证码
  let  img = document.getElementById("vcode");
  let refreshCode=function (){
    img.src = baseurl + "/user/checkCodeServlet?" + new Date().getTime();
  }
</script>

</html>

