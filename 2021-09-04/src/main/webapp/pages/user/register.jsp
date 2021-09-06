<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册</title>
</head>
<body>
<form action="../../user/register" method="post">
    <label for="inputEmail">账号</label>
    <input type="email" id="inputEmail" name="useraccount" placeholder="请输入账号，邮箱格式"><br>

    <label for="inputusername">用户名</label>
    <input type="text" id="inputusername" name="username" placeholder="用户名"><br>


    <label for="inputPassword">密码</label>
    <input type="password" id="inputPassword" name="password" placeholder="密码"><br>

    <input type="submit" value="注册">
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="login.jsp">登录</a>
</form>
</body>
</html>