<%--
  Created by IntelliJ IDEA.
  User: ASUA
  Date: 2021/10/2
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    num=${num}
    <br>
    num=${pageContext.request.getAttribute("num")}
    <br>
    num=${requestScope.num}
</body>
</html>
