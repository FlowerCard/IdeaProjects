<%--
  Created by IntelliJ IDEA.
  User: ASUA
  Date: 2021/10/9
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>User</title>
        <script src="js/jquery-3.4.1.min.js"></script>
    </head>
    <body>
        <button id="getUsers">获取用户列表</button>
        <br>
        <input type="text" name="userId" id="userId" />
        <button id="getUser">获取用户</button>
    </body>
</html>
<script>
    $("#getUsers").click(function (){
        $.get("${pageContext.request.contextPath}/user/users",function (res){
            console.log(res);
        })
    });
    
    $("#getUser").click(function (){
        var id = $("#userId").val();
        $.get("${pageContext.request.contextPath}/user/users/" + id,function (res){
            console.log(res);
        })
    });
</script>
