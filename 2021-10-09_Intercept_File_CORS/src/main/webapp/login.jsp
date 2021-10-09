<%--
  Created by IntelliJ IDEA.
  User: ASUA
  Date: 2021/10/9
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Login</title>
        <script src="js/jquery-3.4.1.min.js"></script>
    </head>
    <body>
        <button id="btn_login">登录</button>
    </body>
</html>
<script>
    $("#btn_login").click(function (){
        $.post("user/login",function (res){
            console.log(res)
        })
    });
</script>
