<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/11/18
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
  <body>

    用户名：<label for="username"></label><input type="text" name="username" id="username">
    密码：<label for="password"></label><input type="text" name="password" id="password">
    <input type="button" id="btn" value="登录">

    <script>
      $(function (){
        $('#btn').on("click",function (){

          $.ajax({
            url: "${pageContext.request.contextPath}/login",
            data: {username: $('#username').val(),password:$('#password').val()},
            type: "post",
            success:function (data){
              console.log(data)
             alert(data.msg)
            },
            dataType: "json"
                  }
          )

            <%--$.post("${pageContext.request.contextPath}/login",{username:$('#username').val(),password:$('#password').val()}--%>
            <%--,function (rs){--%>
            <%--    alset(rs)--%>
            <%--    },"text"--%>
            <%--)--%>
        })
      })
    </script>

  </body>
</html>
