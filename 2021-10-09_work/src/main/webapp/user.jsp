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
        <hr>
        <input type="text" name="userId" id="userId" />
        <button id="getUser">获取用户</button>

        <hr>
    
        <div>
            用户名：<input type="text" name="username" id="add_username" /><br>
            密码：<input type="password" name="password" id="add_password" /><br>
            信息：<input type="text" name="info" id="add_info" /><br>
            <button id="addUser">新增用户</button>
        </div>
    
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
    
    $("#addUser").click(function (){
        var user = {};
        user.username=$("#add_username").val();
        user.password=$("#add_password").val();
        user.info=$("#add_info").val();
        $.ajax({
            method:"post",
            url:"${pageContext.request.contextPath}/user/users",
            data:JSON.stringify(user),
            contentType:"application/json",
            success:function (res){
                console.log(res)
            }
        })
    });
</script>
