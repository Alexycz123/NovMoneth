
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/11/1
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>

  </head>
  <body>
<form class="form-inline">
    <div class="form-group">
        <label class="sr-only" for="username">用户名</label>
        <input type="text" class="form-control" id="username" placeholder="Email">
    </div>
    <div class="form-group">
        <label class="sr-only" for="password">密码</label>
        <input type="password" class="form-control" id="password" placeholder="Password">
    </div>
    <div class="form-group">
        <label class="sr-only" for="password">验证码</label>
        <input type="password" class="form-control" id="code" placeholder="Code">
    </div>
    <div class="form-group">
        <img src="" id="checkCode" style="width: 100px;height: 50px">
    </div>


    <button type="button" class="btn btn-default" id="btn">Sign in</button>
</form>

  </body>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
  <script src="${pageContext.request.contextPath}/static/js/jquery-3.2.1.min.js"></script>
  <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>


  <script type="text/javascript">
    let baseurl="${pageContext.request.contextPath}";
    //开始就发送验证码
    let  img = document.getElementById("checkCode");

    let  date = new Date().getTime();
    img.src = baseurl+"/checkCodeServlet?"+date;

        //1.获取图片对象
        //2.绑定单击事件
    $(document).on('click','#checkCode',function() {
        img.onclick = function () {
            let  date = new Date().getTime();
            img.src = baseurl + "/checkCodeServlet?" + date;
        }
    });

    $(document).on('click','#btn',function(){
      let username = $('#username').val();
      let password = $('#password').val();
      let code=$('#code').val();

     $.post(baseurl+"/login.do",{username : username,password: password,code: code},function (rs){

         alert(rs)
     })
    });


    </script>
</html>
