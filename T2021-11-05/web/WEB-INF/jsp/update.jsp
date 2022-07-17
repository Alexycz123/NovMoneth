<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/11/9
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新功能</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">修改联系人</h3>
    <form action="${pageContext.request.contextPath}/user/update" method="post">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name"  readonly="readonly" placeholder="请输入姓名"
            value="${user.name}"             required="required"
            />
        </div>

        <input type="hidden" value="${user.id}" name="id">
        <input type="hidden" name="page" value="${page}">
        <input type="hidden" name="limit" value="${limit}">

        <div class="form-group">
            <label>性别：</label>
            <c:if test="${user.gender=='男'}">
            <input type="radio" name="gender" value="男" checked />男
            <input type="radio" name="gender" value="女"  />女
            </c:if>
            <c:if test="${user.gender=='女'}">
                <input type="radio" name="gender" value="男"/>男
                <input type="radio" name="gender" value="女"   checked  />女
            </c:if>
        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age"  name="age" placeholder="请输入年龄"
            value="${user.age}"             required="required"
            />
        </div>

        <div class="form-group">
            <%--@declare id="address"--%><label for="address">籍贯：</label>
            <select name="address" class="form-control"             required="required" >
                <option></option>
                <c:forEach items="${provinceList}" var="province">
                    <option value="${province.provinceName}"
                            <c:if test="${province.provinceName==user.address}">
                                selected
                            </c:if>
                    >${province.provinceName}</option>
                </c:forEach>

            </select>
        </div>

        <div class="form-group">
            <%--@declare id="qq"--%><label for="qq">QQ：</label>
            <input type="text" class="form-control" name="qq" placeholder="请输入QQ号码"
            value="${user.qq}"             required="required"
            />
        </div>

        <div class="form-group">
            <%--@declare id="email"--%><label for="email">Email：</label>

            <input type="text" class="form-control" name="email" placeholder="请输入邮箱地址"
            value="${user.email}"             required="required"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />

        </div>
    </form>
</div>
</body>
</html>
