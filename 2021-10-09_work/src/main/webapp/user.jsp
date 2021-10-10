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

        <hr>
    
        <div>
            <h5>修改用户</h5>
            <input type="hidden" name="id" id="modify_id"/>
            用户名：<input type="text" name="username" id="modify_username" /><br>
            密码：<input type="password" name="password" id="modify_password" /><br>
            信息：<input type="text" name="info" id="modify_info" /><br>
            <button id="modifyUser">修改用户</button>
        </div>

        <hr>
    
        <div>

            <input type="text" name="id" id="delete_id" />
            <button id="deleteUser">删除用户</button>
            
        </div>
    
    </body>
</html>
<script>
    
    $("#deleteUser").click(function (){
        var id = $("#delete_id").val();
        $.ajax({
            method: "delete",
            url: "http://localhost:8080/user/users/" + id,
            success: function (res){
                console.log(res)
            }
        })
    });

    $("#modifyUser").click(function (){
        var user = {};
        user.id = $("#modify_id").val();
        user.username = $("#modify_username").val();
        user.password = $("#modify_password").val();
        user.info = $("#modify_info").val();
        $.ajax({
            method: "put",
            url: "http://localhost:8080/user/users",
            data: JSON.stringify(user),
            contentType: "application/json",
            success:function (res){
                if (res != null){
                    alert("修改成功" + res)
                } else {
                    alert("修改失败" + res)
                }
            }
        })
    });
    
    $("#getUsers").click(function (){
        $.get("${pageContext.request.contextPath}/user/users",function (res){
            console.log(res);
        })
    });
    
    $("#getUser").click(function (){
        var id = $("#userId").val();
        $.get("${pageContext.request.contextPath}/user/users/" + id,function (res){
            
            console.log(res)
            
            $("#modify_id").val(res.id);
            $("#modify_username").val(res.username);
            $("#modify_password").val(res.password);
            $("#modify_info").val(res.info);
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
