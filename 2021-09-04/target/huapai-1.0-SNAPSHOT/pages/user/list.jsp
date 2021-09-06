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
</head>
<body>
    
    <div style="text-align: center">
        <table border="1" cellpadding="10" cellspacing="0">
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
                <td>${user.useraccount}</td>
                <td>${user.username}</td>
                <td>${user.realname}</td>
                <td>
                    <fmt:formatDate value="${user.createtime}" pattern="yyyy-MM-dd"/>
                </td>
                <td>
                    <fmt:formatDate value="${user.modifiedtime}" pattern="yyyy-MM-dd"/>
                </td>
            </c:forEach>
            </tbody>
        </table>
    </div>

</body>
</html>
