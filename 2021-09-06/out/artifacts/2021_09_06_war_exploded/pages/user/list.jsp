<%--
  Created by IntelliJ IDEA.
  User: ASUA
  Date: 2021/9/6
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>用户列表</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="css/bootstrap.min.css">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="css/bootstrap-theme.min.css">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery-3.4.1.min.js"></script>
</head>
<body>
    <div class="container">
        <div class="table-responsive">
            <table id="tableId" class="table table-striped table-bordered">
                <thead>
                    <tr>
                        <th>USERACCOUNT</th>
                        <th>USERNAME</th>
                        <th>REALNAME</th>
                        <th>CREATETIME</th>
                        <th>MODIFIEDTIME</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.useraccount}</td>
                        <td>${user.username}</td>
                        <td>${user.realname}</td>
                        <td>
                            <fmt:formatDate value="${user.createTime}" pattern="yyyy-MM-dd"/>
                        </td>
                        <td>
                            <fmt:formatDate value="${user.modifiedTime}" pattern="yyyy-MM-dd"/>
                        </td>
                        <td>
                            <a href="../user/deleteUser?delid=${user.id}">删除</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="#" id="modif">修改</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>