<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <!-- 包含公共的JSP代码片段 -->

    <title>餐馆王平台</title>
    <jsp:include page="resource/static_resouce.jsp"/>
    <link href="${front_detail_path}/style/css/index.css" rel="stylesheet" type="text/css"/>
</head>
<body style="text-align: center">
<div id="all">
    <div id="menu">
        <!-- 显示菜品的div -->
        <div id="top">
            <ul>
                <!-- 循环列出餐品 -->
                <c:forEach items="${pageBean.beanList}" var="pageList">
                    <li>
                        <dl>
                            <dt>
                                <a href="/front?method=dishesDetail&dishesId=${pageList.dishesId}">
                                    <img width="214px" height="145px"
                                         src="${pageContext.request.contextPath}${pageList.dishesImg}"/>
                                </a>
                            </dt>
                            <dd class="f1">
                                <a href="/front?method=dishesDetail&dishesId=${pageList.dishesId}">${pageList.dishesName}</a>
                            </dd>
                            <dd class="f2">
                                <a href="/front?method=dishesDetail&dishesId=${pageList.dishesId}">&yen;
<%--                                        ${pageList.dishesPrice}--%>
                                    <c:choose>  
                                        <c:when test="${sessionScope.loginUser.member == 1}">${pageList.dishesPrice}</c:when>
                                        <c:when test="${sessionScope.loginUser.member == 2}">${pageList.dishesMemberPrice}</c:when>
                                    </c:choose>
                                </a>
                            </dd>
                        </dl>
                    </li>
                </c:forEach>
            </ul>
        </div>

        <!-- 底部分页导航条div -->
        <div id="foot">
						<span
                                style="float:left; line-height:53PX; margin-left:-50px; font-weight:bold; ">
							<span style="font-weight:bold">
                                <c:choose>
                                    <c:when test="${pageBean.currentPage - 1 == 0}">
                                         <a
                                                 <c:if test="${page == pageBean.currentPage}">style="color: black" </c:if>
                                                 href="#"
                                                 style=" text-decoration:none;color:#000000; font-weight:bold">&lt;&lt;</a>
                                    </c:when>
                                    <c:when test="${pageBean.currentPage - 1 != 0}">
                                        <a
                                                <c:if test="${page == pageBean.currentPage}">style="color: black" </c:if>
                                                href="/front?method=search&currentPage=${pageBean.currentPage-1}&cuisineId=${cuisineId}"
                                                style=" text-decoration:none;color:#000000; font-weight:bold">&lt;&lt;</a>
                                    </c:when>
                                </c:choose>
                            </span>
						</span>


            <div id="btn">
                <ul>
                    <!-- 参看 百度, 谷歌是 左 5 右 4 -->
                    <c:forEach begin="1" end="${pageBean.totalPage}" var="page">
                        <li><a
                                <c:if test="${page == pageBean.currentPage}">style="color: black" </c:if>
                                href="/front?method=search&currentPage=${page}&cuisineId=${cuisineId}">${page}</a></li>
                    </c:forEach>
                </ul>
            </div>


            <span style="float:right; line-height:53px; margin-right:10px;  ">
                            <c:choose>
                                <c:when test="${pageBean.currentPage+1 > pageBean.totalPage}">
                                    <a
                                            <c:if test="${page == pageBean.currentPage}">style="color: black" </c:if>
                                            href="#"
                                            style=" text-decoration:none;color:#000000; font-weight:bold">&gt;&gt;</a>
                                </c:when>
                                <c:when test="${pageBean.currentPage+1 <= pageBean.totalPage}">
                                    <a
                                            <c:if test="${page == pageBean.currentPage}">style="color: black" </c:if>
                                            href="/front?method=search&currentPage=${pageBean.currentPage+1}&cuisineId=${cuisineId}"
                                            style=" text-decoration:none;color:#000000; font-weight:bold">&gt;&gt;</a>
                                </c:when>
                            </c:choose>
						</span>


        </div>

    </div>

    <!-- 右边菜系列表，菜品搜索框  -->
    <div id="dish_class">
        <div id="dish_top">
            <ul>
                <li class="dish_num"></li>
                <li>
                    <a href="javascript:void(0)">
                        <img src="${front_detail_path}/style/images/call2.gif"/>
                    </a>
                </li>
            </ul>
        </div>

        <div id="dish_2">
            <ul style="height:250px;overflow-y:scroll;">
                <c:forEach items="${sessionScope.cuisineList}" var="cuisineList">
                    <li>
                        <a href="/front?method=search&cuisineId=${cuisineList.cuisineId}">${cuisineList.cuisineName}</a>
                    </li>
                </c:forEach>

            </ul>
        </div>
        <div id="dish_3">
            <!-- 搜索菜品表单  -->
            <form action="/front" method="post">
                <table width="166px">
                    <tr>
                        <td>
                            <input type="text" id="dish_name" name="dishesName" value="${dishesName}"
                                   class="select_value"/>
                            <input type="hidden" value="search" name="method">
                        </td>
                    </tr>
                    <tr>
                        <td><input type="submit" id="sub" value=""/></td>
                    </tr>
                    <tr>
                        <td>
                            <a href="/front?method=search">
                                <img src="${front_detail_path}/style/images/look.gif"/>
                            </a>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>

</div>
</body>
</html>
