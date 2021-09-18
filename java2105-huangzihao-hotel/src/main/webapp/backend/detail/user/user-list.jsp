<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- 包含公共的JSP代码片段 -->

    <title>餐馆王平台</title>
    <jsp:include page="../resource/static_resouce.jsp"/>
</head>
<body>
<!-- 页面标题 -->
<div id="TitleArea">
    <div id="TitleArea_Head"></div>
    <div id="TitleArea_Title">
        <div id="TitleArea_Title_Content">
            <img border="0" width="13" height="13" src="${backend_detail_path}/style/images/title_arrow.gif"/> 用户列表
        </div>
    </div>
    <div id="TitleArea_End"></div>
</div>


<!-- 过滤条件 -->
<div id="QueryArea">
    <form action="/user?method=search" method="get">
        <input type="hidden" name="method" value="search">
        <input type="text" name="keyword" title="请输入用户名称" value="${keyword}">
        <input type="submit" value="搜索">
    </form>
</div>
<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
    <table class="MainArea_Content" align="center" cellspacing="0" cellpadding="0">
        <!-- 表头-->
        <thead>
        <tr align="center" valign="middle" id="TableTitle">
            <td>用户编号</td>
            <td>用户名</td>
            <td>昵称</td>
            <td>是否管理员</td>
            <td>手机号</td>
            <td>性别</td>
            <td>用户状态</td>
            <td>是否会员</td>
            <td>账户余额</td>
        </tr>
        </thead>
        <!--显示数据列表 -->
        <tbody id="TableData">
        <c:forEach items="${userList}" var="user">
            <tr class="TableDetail1" align="center" valign="middle">
                <td>${user.userId}&nbsp;</td>
                <td>${user.username}&nbsp;</td>
                <td>${user.nickname}&nbsp;</td>
                <td>
                        <c:choose>
                            <c:when test="${user.admin == 1}">管理员</c:when>
                            <c:when test="${user.admin == 2}">普通用户</c:when>
                        </c:choose>
                            &nbsp;
                </td>
                <td>${user.phone}&nbsp;</td>
                <td>
                        <c:choose>
                            <c:when test="${user.gender == 1}">男</c:when>
                            <c:when test="${user.gender == 2}">女</c:when>
                        </c:choose>
                            &nbsp;
                </td>
                <td>
                        <c:choose>
                            <c:when test="${user.status == 1}">激活</c:when>
                            <c:when test="${user.status == 2}">未激活</c:when>
                            <c:when test="${user.status == 3}">锁定</c:when>
                            <c:when test="${user.status == 4}">异常</c:when>
                        </c:choose>
                            &nbsp;
                </td>
                <td>
                        <c:choose>
                            <c:when test="${user.member == 1}">非会员</c:when>
                            <c:when test="${user.member == 2}">会员</c:when>
                        </c:choose>
                            &nbsp;
                </td>
                <td>${user.balance}&nbsp;</td>
                <td>
                    <a href="/user?method=updateui&userId=${user.userId}" class="FunctionButton">更新</a>
                    <a href="/user?method=delete&userId=${user.userId}" onClick="return delConfirm('${user.username}');"class="FunctionButton">删除</a>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>

    <!-- 其他功能超链接 -->
<%--    <div id="TableTail" align="center">--%>
<%--        <div class="FunctionButton"><a href="/dish?method=saveui">添加</a></div>--%>
<%--    </div>--%>
</div>
</body>
</html>
