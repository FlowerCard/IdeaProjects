<%--
  Created by IntelliJ IDEA.
  User: ASUA
  Date: 2021/10/11
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Title</title>
        <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
        <link rel="stylesheet" href="../css/bootstrap.min.css">

        <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
        <link rel="stylesheet" href="../css/bootstrap-theme.min.css">

        <script src="../js/jquery-3.4.1.min.js"></script>
        
        <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
        <script src="../js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">

            <h1 align="center">
                用户列表
            </h1>
            
            <div style="text-align: right">
                <!-- Button trigger modal -->
                <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#addUser">
                    添加用户
                </button>

                <!-- Modal -->
                <div class="modal fade" id="addUser" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="text-align: left">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="myModalLabel">用户信息</h4>
                            </div>
                            <div class="modal-body">
                                <form action="http://localhost:8080/ssm/user/addUser" method="post">
                                    <div class="form-group">
                                        <label for="username">用户名</label>
                                        <input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名">
                                    </div>
                                    <div class="form-group">
                                        <label for="password">密码</label>
                                        <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
                                    </div>
                                    <div class="form-group">
                                        <label for="email">邮箱</label>
                                        <input type="email" class="form-control" id="email" name="email" placeholder="请输入邮箱">
                                    </div>
                                    <div class="form-group">
                                        <label for="info">信息</label>
                                        <input type="text" class="form-control" id="info" name="info" placeholder="请输入用户信息">
                                    </div>
                                    <button type="submit" class="btn btn-default">提交</button>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            </div>
                        </div>
                    </div>
                </div>
                
            </div>
            
            <table class="table table-bordered" id="userTable">
                <tr>
                    <th>编号</th>
                    <th>用户名</th>
                    <th>邮箱</th>
                    <th>信息</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${pageInfo.list}" begin="0" end="${pageInfo.size}" var="user">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.username}</td>
                        <td>${user.email}</td>
                        <td>${user.info}</td>
                        <td>
                            <button type="button" class="btn btn-primary" onclick="modifyUser(${user.id})" data-target="#modifyUser" data-toggle="modal">修改</button>
                            
<%--                            修改用户--%>
                            <div class="modal fade" id="modifyUser" tabindex="-1" role="dialog" aria-labelledby="modifyUserModalLabel" style="text-align: left">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                            <h4 class="modal-title" id="modifyUserModalLabel">修改用户</h4>
                                        </div>
                                        <div class="modal-body">
                                            <form action="http://localhost:8080/ssm/user/modifyUser" method="post">
                                                <div class="form-group">
                                                    <input type="hidden" class="form-control" id="modifyId" name="id" placeholder="请输入用户名">
                                                </div>
                                                <div class="form-group">
                                                    <label for="modifyUsername">用户名</label>
                                                    <input type="text" class="form-control" id="modifyUsername" name="username" placeholder="请输入用户名">
                                                </div>
                                                <div class="form-group">
                                                    <label for="modifyPassword">密码</label>
                                                    <input type="password" class="form-control" id="modifyPassword" name="password" placeholder="请输入密码">
                                                </div>
                                                <div class="form-group">
                                                    <label for="modifyEmail">邮箱</label>
                                                    <input type="email" class="form-control" id="modifyEmail" name="email" placeholder="请输入邮箱">
                                                </div>
                                                <div class="form-group">
                                                    <label for="modifyInfo">信息</label>
                                                    <input type="text" class="form-control" id="modifyInfo" name="info" placeholder="请输入用户信息">
                                                </div>
                                                <button type="submit" class="btn btn-default">提交</button>
                                            </form>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            <button type="button" class="btn btn-danger" onclick="removeUser(${user.id})">删除</button>

                            
                        </td>
                    </tr>
                </c:forEach>
            </table>

            <nav aria-label="Page navigation" style="text-align: center">
                <ul class="pagination">
                    <li>
                        <c:if test="${pageInfo.pageNum > 1}">
                            <a href="http://localhost:8080/ssm/user/users?currentPage=${pageInfo.pageNum-1}" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </c:if>
                    </li>
                    <c:forEach begin="1" end="${pageInfo.pages}" var="currentPage">
                        <li><a href="http://localhost:8080/ssm/user/users?currentPage=${currentPage}">${currentPage}</a></li>
                    </c:forEach>
                    <li>
                        <c:if test="${pageInfo.pageNum < pageInfo.pages}">
                            <a href="http://localhost:8080/ssm/user/users?currentPage=${pageInfo.pageNum+1}" aria-label="Previous">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </c:if>
                    </li>
                </ul>
            </nav>
        </div>
    </body>
</html>
<script>
    function modifyUser(obj){
        $.get("http://localhost:8080/ssm/user/users/" + obj,function (res){
            $("#modifyId").val(res.id);
            $("#modifyUsername").val(res.username);
            $("#modifyEmail").val(res.email);
            $("#modifyInfo").val(res.info);
        })
    }
    
    function removeUser(obj){
        var ret = confirm("你正准备删除ID为" + obj + "的用户，此操作确定后不可恢复！请谨慎操作");
        var id = JSON.stringify(obj);
        if (ret){
            $.ajax({
                method:"post",
                url:"http://localhost:8080/ssm/user/delete",
                contentType:"application/json",
                data:id,
                success:function (res){
                    window.location.reload();
                }
            })
        }
    }
    
</script>