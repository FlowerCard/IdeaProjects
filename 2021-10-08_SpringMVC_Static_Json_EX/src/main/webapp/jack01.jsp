<%--
  Created by IntelliJ IDEA.
  User: ASUA
  Date: 2021/10/8
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>jack01</title>
        <script src="js/jquery-3.4.1.min.js"></script>
    </head>
    <body>
        <button id="btn_getUser">获取用户</button>
        <button id="btn_sendUser">发送用户</button>
    </body>
</html>
<script>
    $("#btn_getUser").click(function (){
        $.ajax({
            method:"GET",
            url:"http://localhost:8080/jack/jack01",
            dataType:"JSON",
            success:function (res){
                console.log(res)
            }
        })
    })
    
    $("#btn_sendUser").click(function (){
        var user = {};
        user.id=1002;
        user.username="test02";
        user.password="123";
        user.birth="2010-11-21";
        user.balance=123.123;
        $.ajax({
            method: "POST",
            url: "http://localhost:8080/jack/jack02",
            data: JSON.stringify(user),
            contentType: "application/json",
            success:function (res){
                console.log(res)
            }
        })
    })
</script>
