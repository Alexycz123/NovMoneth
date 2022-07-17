<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    <script src="${pageContext.request.contextPath}/js/layer.js"></script>

    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>

    <div style="float: left;">

        <form class="form-inline" action="${pageContext.request.contextPath}/user/list" method="post">
            <div class="form-group">
                <label for="exampleInputName2">姓名</label>
                <input type="text" class="form-control" value="${pageBean.userQuery.name}" name="name" id="exampleInputName2" >
            </div>


            <div class="form-group">
                <div class="col-sm-6">
                <label for="exampleInputName3">籍贯</label>
                <select name="address" class="select" >
                    <option></option>
                    <c:forEach items="${provinceList}" var="province">
                        <option value="${province.provinceName}"
                                <c:if test="${province.provinceName==pageBean.userQuery.address}">
                                    selected
                                </c:if>
                        >${province.provinceName}</option>
                    </c:forEach>
                </select>
                </div>
<%--                <input type="text" class="form-control" value="${pageBean.userQuery.address}" name="address" id="exampleInputName3" >--%>
            </div>

            <div class="form-group">
                <label for="exampleInputEmail2">邮箱</label>
                <input type="text" class="form-control"  value="${pageBean.userQuery.email}" name="email" id="exampleInputEmail2"  >
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>

    </div>

    <div style="float: right;margin: 5px;">

        <a class="btn btn-primary" href="${pageContext.request.contextPath}/user/toAddPage?page=${pageBean.page}&limit=${pageBean.limit}">添加联系人</a>
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/user/restoreAll?page=${pageBean.page}&limit=${pageBean.limit}">恢复所有</a>
        <a class="btn btn-primary" onclick="doDelete2(${pageBean.page},${pageBean.limit})">删除选中</a>

    </div>

    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th><input type="checkbox" id="cbAll"></th>
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>籍贯</th>
            <th>QQ</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>

        <c:forEach items="${pageBean.userList}" var="user" varStatus="s">
            <tr>
                <td><input type="checkbox" name="cb" value="${user.id}"/></td>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.gender}</td>
                <td>${user.age}</td>
                <td>${user.address}</td>
                <td>${user.qq}</td>
                <td>${user.email}</td>
                <td><a class="btn btn-default btn-sm" href="
                ${pageContext.request.contextPath}/user/toUpdate?id=${user.id}&page=${pageBean.page}&limit=${pageBean.limit}">修改</a>&nbsp;
                    <a class="btn btn-default btn-sm" onclick="doDelete(${user.id},${pageBean.page},${pageBean.limit})">删除</a></td>
            </tr>

        </c:forEach>


    </table>
    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <c:if test="${pageBean.page==1}">
                <li class="disabled">
                    <a href="${pageContext.request.contextPath}/user/list?page=${pageBean.page-1}&limit=${pageBean.limit}&name=${pageBean.userQuery.name}&address=${pageBean.userQuery.address}&email=${pageBean.userQuery.email}"
                            <c:if test="${pageBean.page<=1 }">  onclick="javascript:return false;"</c:if>
                       aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                </c:if>

                <c:if test="${pageBean.page!=1}">
                    <li>
                        <a href="${pageContext.request.contextPath}/user/list?page=${pageBean.page-1}&limit=${pageBean.limit}&name=${pageBean.userQuery.name}&address=${pageBean.userQuery.address}&email=${pageBean.userQuery.email}"
                                <c:if test="${pageBean.page<=1 }">  onclick="javascript:return false;"</c:if>
                           aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>



<%--                <li><a href="${pageContext.request.contextPath}/user/list?page=1&limit=${pageBean.limit}&name=${pageBean.userQuery.name}&address=${pageBean.userQuery.address}&email=${pageBean.userQuery.email}">1</a></li>--%>

<%--                <c:if test="${pageBean.userPageTotal>=2}">--%>
<%--                <li><a href="${pageContext.request.contextPath}/user/list?page=2&limit=${pageBean.limit}&name=${pageBean.userQuery.name}&address=${pageBean.userQuery.address}&email=${pageBean.userQuery.email}"--%>
<%--                        <c:if test="${2> pageBean.userPageTotal }">  onclick="javascript:return false;"</c:if>--%>
<%--                >2</a></li>--%>
<%--                </c:if>--%>


<%--                <c:if test="${pageBean.userPageTotal>=3}">--%>
<%--                <li><a href="${pageContext.request.contextPath}/user/list?page=3&limit=${pageBean.limit}&name=${pageBean.userQuery.name}&address=${pageBean.userQuery.address}&email=${pageBean.userQuery.email}"--%>
<%--                        <c:if test="${3> pageBean.userPageTotal }">  onclick="javascript:return false;"</c:if>--%>
<%--                >3</a></li>--%>
<%--                </c:if>--%>


<%--                <c:if test="${pageBean.userPageTotal>=4}">--%>
<%--                <li><a href="${pageContext.request.contextPath}/user/list?page=4&limit=${pageBean.limit}&name=${pageBean.userQuery.name}&address=${pageBean.userQuery.address}&email=${pageBean.userQuery.email}"--%>
<%--                        <c:if test="${4> pageBean.userPageTotal }">  onclick="javascript:return false;"</c:if>--%>
<%--                >4</a></li>--%>
<%--                </c:if>--%>



<%--                <c:if test="${pageBean.userPageTotal>=5}">--%>
<%--                <li><a href="${pageContext.request.contextPath}/user/list?page=5&limit=${pageBean.limit}&name=${pageBean.userQuery.name}&address=${pageBean.userQuery.address}&email=${pageBean.userQuery.email}"--%>
<%--                        <c:if test="${5> pageBean.userPageTotal }">  onclick="javascript:return false;"</c:if>--%>
<%--                >5</a></li>--%>
<%--                </c:if>--%>

                <c:forEach begin="1" end="${pageBean.userPageTotal}" var="i">

                    <c:if test="${pageBean.page==i}">
                     <li class="active"><a href="${pageContext.request.contextPath}/user/list?page=${i}&limit=${pageBean.limit}&name=${pageBean.userQuery.name}&address=${pageBean.userQuery.address}&email=${pageBean.userQuery.email}"
                      <c:if test="${i> pageBean.userPageTotal }">  onclick="javascript:return false;"</c:if>
                                        >${i}</a></li>
                    </c:if>
                    <c:if test="${pageBean.page!=i}">
                        <li><a href="${pageContext.request.contextPath}/user/list?page=${i}&limit=${pageBean.limit}&name=${pageBean.userQuery.name}&address=${pageBean.userQuery.address}&email=${pageBean.userQuery.email}"
                                <c:if test="${i> pageBean.userPageTotal }">  onclick="javascript:return false;"</c:if>
                        >${i}</a></li>
                    </c:if>

                </c:forEach>







                <c:if test="${pageBean.page==pageBean.userPageTotal}">
                <li class="disabled">
                    <a href="${pageContext.request.contextPath}/user/list?page=${pageBean.page+1}&limit=${pageBean.limit}&name=${pageBean.userQuery.name}&address=${pageBean.userQuery.address}&email=${pageBean.userQuery.email}"
                            <c:if test="${pageBean.page>=pageBean.userPageTotal }">  onclick="javascript:return false;"</c:if>
                       aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                </c:if>

                <c:if test="${pageBean.page!=pageBean.userPageTotal}">
                    <li>
                        <a href="${pageContext.request.contextPath}/user/list?page=${pageBean.page+1}&limit=${pageBean.limit}&name=${pageBean.userQuery.name}&address=${pageBean.userQuery.address}&email=${pageBean.userQuery.email}"
                                <c:if test="${pageBean.page>=pageBean.userPageTotal }">  onclick="javascript:return false;"</c:if>
                           aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>
                <span style="font-size: 25px;margin-left: 5px;">
                    共${pageBean.count}
                    条记录，共${pageBean.userPageTotal}页
                </span>

            </ul>
        </nav>


    </div>
</div>
</body>

    <script>

      document.getElementById("cbAll").onclick=function (){
          let cb=document.getElementsByName("cb");
          for(let i=0;i<cb.length;i++){
              cb[i].checked=this.checked;
          }
      }


        function doDelete(uid,page,limit){
            layer.confirm("确认要删除吗？",function (index){
                location.href="${pageContext.request.contextPath}/user/delete?id="+uid+"&page="+page+"&limit="+limit;
                layer.close(index)
            })
        }

      function doDelete2(page,limit){
          let arr=[];
          let checkbox=document.getElementsByName('cb');
          for(let i=0;i<checkbox.length;i++){
              if(checkbox[i].checked==true||checkbox[i].checked=="checked"){
                  arr.push(checkbox[i].value);
                  // alert(checkbox[i].value);
              }
          }
          console.log(arr)
          if(arr.length===0){
              layer.confirm("请选择要删除的元素")
          }else {
              layer.confirm("确认要批量删除吗？",function (index){
                  location.href="${pageContext.request.contextPath}/user/delete2?ids="+arr+"&page="+page+"&limit="+limit;
                  layer.close(index)
              })
          }

        }

    </script>


</html>
