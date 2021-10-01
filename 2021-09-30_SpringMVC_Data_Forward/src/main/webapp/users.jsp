<%--
  Created by IntelliJ IDEA.
  User: ASUA
  Date: 2021/10/1
  Time: 7:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
    <body>
        <form action="${pageContext.request.contextPath}/param/p08" method="post">
            编号：<input type="text" name="users[0].id"/> <br>
            姓名：<input type="text" name="users[0].username" /> <br>
            密码：<input type="text" name="users[0].password"/> <br>
            生日：<input type="text" name="users[0].birth" /> <br>
            <hr>
            编号：<input type="text" name="users[1].id"/> <br>
            姓名：<input type="text" name="users[1].username" /> <br>
            密码：<input type="text" name="users[1].password"/> <br>
            生日：<input type="text" name="users[1].birth" /> <br>
            <input type="submit" value="提交" />
        </form>
    </body>
</html>
