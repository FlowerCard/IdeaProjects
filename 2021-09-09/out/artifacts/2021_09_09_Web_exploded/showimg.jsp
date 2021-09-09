<%--
  Created by IntelliJ IDEA.
  User: ASUA
  Date: 2021/9/9
  Time: 9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>显示图片</title>
</head>
<body>
    <c:forEach items="files" var="file">
        <img src="${file}">
    </c:forEach>
</body>
</html>
