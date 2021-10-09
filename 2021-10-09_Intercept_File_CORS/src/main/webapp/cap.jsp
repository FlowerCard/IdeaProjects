<%--
  Created by IntelliJ IDEA.
  User: ASUA
  Date: 2021/10/9
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Cap</title>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/cap/check">
            验证码：<input type="text" name="code"/>
            <img src="${pageContext.request.contextPath}/captcha">
            <br>
            <input type="submit" value="提交">
        </form>
    </body>
</html>
