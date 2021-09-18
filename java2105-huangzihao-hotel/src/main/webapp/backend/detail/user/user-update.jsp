<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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


            <img border="0" width="13" height="13" src="${backend_detail_path}/style/images/title_arrow.gif"/> 更新新菜品


        </div>
    </div>
    <div id="TitleArea_End"></div>
</div>

<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
    <!-- 表单内容 -->
    <form action="/user?method=update" method="post" enctype="application/x-www-form-urlencoded">
        <!-- 本段标题（分段标题） -->
        <div class="ItemBlock_Title">
            <img width="4" height="7" border="0" src="${backend_detail_path}/style/images/item_point.gif"> 用户信息&nbsp;
        </div>
        <!-- 本段表单字段 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <div class="ItemBlock2">
                    <table cellpadding="0" cellspacing="0" class="mainForm">
                        <tr>
                            <td width="80px">用户名</td>
                            <td>
                                ${userInfo.username}
                                *<input type="hidden" name="userId" value="${userInfo.userId}"/></td>
                        </tr>
                        <tr>
                            <td width="80px">昵称</td>
                            <td><input type="text" name="nickname" class="InputStyle" value="${userInfo.nickname}"/> *
                            </td>
                        </tr>
                        <tr>
                            <td>是否管理员</td>
                            <td>
                                <select name="admin" style="width:80px">--%>
                                    <c:forEach begin="1" end="2" step="1" var="id">
                                        <option value="${id}"
                                                <c:if test="${id == userInfo.admin}">selected</c:if>
                                        >
                                            <c:choose>
                                                <c:when test="${id == 1}">管理员</c:when>
                                                <c:when test="${id == 2}">普通用户</c:when>
                                            </c:choose>
                                        </option>
                                    </c:forEach>
                                </select>
                                *
                            </td>
                        </tr>
                        <tr>
                            <td>手机号</td>
                            <td><input type="text" name="phone" class="InputStyle"
                                       value="${userInfo.phone}"/> *
                            </td>
                        </tr>

                        <tr>
                            <td>性别</td>
                            <td>
                                <select name="gender" style="width:80px">--%>
                                    <c:forEach begin="1" end="2" var="gender">
                                        <option value="${gender}"
                                                <c:if test="${gender == userInfo.gender}">selected</c:if>
                                        >
                                            <c:choose>
                                                <c:when test="${gender == 1}">男</c:when>
                                                <c:when test="${gender == 2}">女</c:when>
                                            </c:choose>
                                        </option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>

                        <tr>
                            <td>用户状态</td>
                            <td>
                                <select name="status" style="width:80px">--%>
                                    <c:forEach begin="1" end="4" var="status">
                                        <option value="${status}"
                                                <c:if test="${status == userInfo.status}">selected</c:if>
                                        >
                                            <c:choose>
                                                <c:when test="${status == 1}">激活</c:when>
                                                <c:when test="${status == 2}">未激活</c:when>
                                                <c:when test="${status == 3}">锁定</c:when>
                                                <c:when test="${status == 4}">异常</c:when>
                                            </c:choose>
                                        </option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>

                        <tr>
                            <td>是否会员</td>
                            <td>
                                <select name="member" style="width:80px">--%>
                                    <c:forEach begin="1" end="2" var="member">
                                        <option value="${member}"
                                                <c:if test="${member == userInfo.member}">selected</c:if>
                                        >
                                            <c:choose>
                                                <c:when test="${member == 1}">非会员</c:when>
                                                <c:when test="${member == 2}">会员</c:when>
                                            </c:choose>
                                        </option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>

                        <tr>
                            <td>账户余额</td>
                            <td>
                                <input type="number" name="balance" class="InputStyle"
                                       value="${userInfo.balance}"/> *
                            </td>
                        </tr>
                        
                    </table>
                </div>
            </div>
        </div>


        <!-- 表单操作 -->
        <div id="InputDetailBar">


            <input type="submit" value="修改" class="FunctionButtonInput">


            <a href="javascript:history.go(-1);" class="FunctionButton">返回</a>
        </div>
    </form>
</div>
</body>
</html>
