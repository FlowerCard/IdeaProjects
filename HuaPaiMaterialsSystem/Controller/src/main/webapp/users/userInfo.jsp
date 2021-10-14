<%--
  Created by IntelliJ IDEA.
  User: Dushine2008
  Date: 2021/8/25
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <title>花牌物料管理系统</title>
        <link rel="icon" href="${pageContext.request.contextPath}/img/logo_r_32.ico">
        <script src="../js/jquery-3.4.1.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/layui/2.6.8/css/layui.css" media="all">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/layui/2.6.8/layui.js" charset="utf-8"></script>

        <style type="text/css">
            body {
                background-image: url(../img/modify.jpg);
                background-size: 1720px 1000px;
                background-repeat: no-repeat;
            }

            #box {
                width: 500px;
                height: 320px;
                margin-left: 60%;
                margin-top: 15%;
            }

        </style>

        <script type="text/javascript">
            $(function () {
                $.ajax({
                    type:"post",
                    url:"http://localhost/users/users/" + ${pageContext.request.getParameter("id")},
                    dataType:"json",
                    success:function (ret) {
                        $("#id").val(ret.id);
                        $("#username").val(ret.username);
                        $("#password").val(ret.password);
                        $("#nickname").val(ret.nickname);
                        $("#address").val(ret.address);
                        $("#telephone").val(ret.telephone);
                    }
                })
            })
        </script>

    </head>
    <body>
        <div id="box" class="container">
            <!-- 用户注册信息表单 -->
            <form action="http://localhost/users/modifyUser" method="post">
                <h1 style="text-align: center;font-weight: 400;font-size: 24px">用户信息</h1>
                <br>
                <br>
                <div class="layui-form-item" hidden="hidden">
                    <label class="layui-form-label">
                        用户名
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" name="id" id="id" required lay-verify="id" placeholder="请输入账号" autocomplete="off"
                               class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux">id不可以修改</div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">
                        用户名
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" name="username" id="username" required lay-verify="username" placeholder="请输入账号" autocomplete="off"
                               class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux">请填写4到20位账户</div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">密码</label>
                    <div class="layui-input-inline">
                        <input type="password" name="password" id="password" required lay-verify="pass" placeholder="请输入密码" autocomplete="off"
                               class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux">请填写4到20位密码</div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">
                        昵称
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" name="nickname" id="nickname" required lay-verify="nickname" placeholder="请输入你的昵称" autocomplete="off"
                               class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux">请输入你的昵称</div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">
                        电话
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" name="telephone" id="telephone" lay-verify="phone" required placeholder="请输入你的联系方式" autocomplete="off"
                               class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux">请输入你的联系方式</div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">
                        住址
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" name="address" id="address" required lay-verify="phone" placeholder="你家在哪里？" autocomplete="off"
                               class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux">请输入你的住址</div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1" onsubmit="modify()">提交</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
<%--            <h2 style="text-align: center;color: red">${registerMsg}</h2>--%>
        </div>
    </body>
</html>

