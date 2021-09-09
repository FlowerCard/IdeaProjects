<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <script src="../../js/jquery-3.4.1.min.js"></script>
    <script>
        $(function () {
            $("#inputEmail").change(function (){
                var useraccountVal = $(this).val();
                //$.post(url,data,success(response,status,xhr),dataType);
                $.post("../../user/exist",{"useraccountValue":useraccountVal},function (result){
                    if (result.success) {
                        $("#useraccountMsg").html("<span style='color: green'>" + result.message + "</span>");
                        $("#subBtn").attr("disabled",false);
                    } else {
                        $("#useraccountMsg").html("<span style='color: red'>" + result.message + "</span>");
                        $("#subBtn").attr("disabled",true);
                    }
                },"json");
                
            })
        })
    </script>
</head>
<body>
<form action="../../user/register" method="post">
    <label for="inputEmail">账号</label>
    <input type="email" id="inputEmail" name="useraccount" placeholder="请输入账号，邮箱格式"/>
    <span id="useraccountMsg"></span><br>

    <label for="inputusername">用户名</label>
    <input type="text" id="inputusername" name="username" placeholder="用户名"/><br>


    <label for="inputPassword">密码</label>
    <input type="password" id="inputPassword" name="password" placeholder="密码"/><br>

    <input type="submit" id="subBtn" value="注册"/>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="login.jsp">登录</a>
</form>
</body>
</html>