<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <script>
        function checkUsername(obj) {
            var useraccountValue = obj.value;
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.open("post","../../user/exist",true);
            xmlhttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
            xmlhttp.send("useraccountValue=" + useraccountValue);
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                    var resultVO = JSON.parse(xmlhttp.responseText);
                    if (resultVO.success) {
                        document.getElementById("useraccountMsg").innerHTML = "<span style='color: green'>" + resultVO.message + "</span>";
                        document.getElementById("subBtn").disabled = false;
                    } else {
                        document.getElementById("useraccountMsg").innerHTML = "<span style='color: red'>" + resultVO.message + "</span>";
                        document.getElementById("subBtn").disabled = true;
                    }
                }
            }
        }
    </script>
</head>
<body>
<form action="../../user/register" method="post">
    <label for="inputEmail">账号</label>
    <input type="email" id="inputEmail" name="useraccount" onchange="checkUsername(this);"  placeholder="请输入账号，邮箱格式"/>
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