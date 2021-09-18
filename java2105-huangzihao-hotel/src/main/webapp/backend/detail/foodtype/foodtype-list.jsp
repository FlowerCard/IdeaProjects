<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
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
				<img border="0" width="13" height="13"
					src="${backend_detail_path}/style/images/title_arrow.gif" /> 菜系列表
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>
	<!-- 过滤条件 -->
	<div id="QueryArea">
		<form action="/cuisine?method=search" method="get">
			<input type="hidden" name="method" value="search">
			&nbsp;&nbsp;菜系名称: <input type="text" name="keyword" placeholder="请输入菜系名称" title="请输入菜系名称" value="${keyword}">
			<input type="submit" value="搜索">
		</form>
	</div>

	<!-- 主内容区域（数据列表或表单显示） -->
	<div id="MainArea">
		<table class="MainArea_Content" align="center" cellspacing="0" cellpadding="0">
			<!-- 表头-->
			<thead>
				<tr align="center" valign="middle" id="TableTitle">
					<td>菜系编号</td>
					<td>菜系名称</td>
					<td>操作</td>
				</tr>
			</thead>
			<!--显示数据列表 -->
			<tbody id="TableData" align="center">
				<c:forEach items="${cuisines}" var="type">
					<tr>
						<td>${type.cuisineId}</td>
						<td>${type.cuisineName}</td>
						<td>
							<a href="/cuisine?method=updateui&typeId=${type.cuisineId}" class="FunctionButton">更新</a>
							<a href="/cuisine?method=delete&typeId=${type.cuisineId}" class="FunctionButton" onClick="return delConfirm('${type.cuisineName}');">删除</a>
						</td>
					</tr>
				</c:forEach>
				
			</tbody>
		</table>
		<!-- 其他功能超链接 -->
		<div id="TableTail" align="center">
			<div class="FunctionButton">
				<a href="${backend_detail_path}/foodtype/foodtype-save.jsp">添加</a>
			</div>
		</div>
	</div>
</body>
</html>
