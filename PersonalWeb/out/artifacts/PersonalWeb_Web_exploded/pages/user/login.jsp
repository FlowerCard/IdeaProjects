<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    
</head>
<body>
    <form action="../../user/login" method="post">
        账号：<input type="email" name="useraccount" placeholder="请输入账号"><br>
        密码：<input type="password" name="password" placeholder="请输入密码"><br>
        验证码：<input type="text" name="inputVcode" placeholder="请输入验证码"> <img src="../../validateCoide" id="vcode" onclick="getVcode(this);"><br>
        <input type="submit" value="登录">
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="register.jsp">注册</a>
    </form>
</body>
</html>
<script>
    function getVcode(obj) {
        obj.src = "../../validateCoide?time=" + new Date().getTime();
    }
</script>