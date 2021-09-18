<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="${front_detail_path}/style/css/bootstrap.min.css">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="${front_detail_path}/style/css/bootstrap-theme.min.css">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="${front_detail_path}/style/js/bootstrap.min.js"></script>
    <script src="${front_detail_path}/style/js/jquery.js"></script>
    <script>
        $(function () {
            $("#username").change(function (){
                var usernameVal = $(this).val();
                //$.post(url,data,success(response,status,xhr),dataType);
                $.post("/user?method=exitisName",{"usernameVal":usernameVal},function (result){
                    if (result.success) {
                        $("#usernameMsg1").html("<span style='color: green'>" + result.message + "</span>");
                        $("#subBtn").attr("disabled",false);
                    } else {
                        $("#usernameMsg1").html("<span style='color: red'>" + result.message + "</span>");
                        $("#subBtn").attr("disabled",true);
                    }
                },"json");

            })
        })
    </script>
</head>
<body>
<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4">
        <form class="form-horizontal" action="/user?method=register" method="post">
            <div class="form-group">
                <label for="username" class="col-sm-2 control-label">用户名</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="username" id="username" placeholder="请输入用户名">
                    <span id="usernameMsg1"></span>
                </div>
            </div>
            <div class="form-group">
                <label for="nickname" class="col-sm-2 control-label">昵称</label>
                <div class="col-sm-10">
                    <input type="text" name="nickname" class="form-control" id="nickname" placeholder="请输入昵称">
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword" class="col-sm-2 control-label">密码</label>
                <div class="col-sm-10">
                    <input type="password" name="password" class="form-control" id="inputPassword" placeholder="请输入密码">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default" id="subBtn">注册</button>
                    <button type="button" class="btn btn-default" onclick="window.location.href='login.jsp'">登录</button>
                </div>
            </div>
        </form>
    </div>
    <div class="col-md-4"></div>
</div>
</body>
</html>