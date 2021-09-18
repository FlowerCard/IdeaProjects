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
			<img border="0" width="13" height="13" src="${backend_detail_path}/style/images/title_arrow.gif"/> 菜品列表
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>


	<!-- 过滤条件 -->
	<div id="QueryArea">
		<form action="/dish?method=search" method="get">
			<input type="hidden" name="method" value="search">
			<input type="text" name="keyword" title="请输入菜品名称" value="${keyword}">
			<input type="submit" value="搜索">
		</form>
	</div>
<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
    <table class="MainArea_Content" align="center" cellspacing="0" cellpadding="0">
        <!-- 表头-->
        <thead>
            <tr align="center" valign="middle" id="TableTitle">
				<td>菜编号</td>
				<td>菜名</td>
				<td>所属菜系</td>
				<td>价格</td>
                <td>会员价格</td>
				<td>操作</td>
			</tr>
		</thead>	
		<!--显示数据列表 -->
        <tbody id="TableData">
			<c:forEach items="${dishes}" var="dish">
				<tr class="TableDetail1" align="center" valign="middle">
					<td>${dish.dishesId}&nbsp;</td>
					<td>${dish.dishesName}&nbsp;</td>
					<td>${dish.cuisine.cuisineName}&nbsp;</td>
					<td>${dish.dishesPrice}&nbsp;</td>
					<td>${dish.dishesMemberPrice}&nbsp;</td>
					<td>
						<a href="/dish?method=updateui&dishId=${dish.dishesId}" class="FunctionButton">更新</a>
						<a href="/dish?method=delete&dishesId=${dish.dishesId}" onClick="return delConfirm('${dish.dishesName}');"class="FunctionButton">删除</a>				
					</td>
				</tr>
			</c:forEach>
        
        </tbody>
    </table>
	
   <!-- 其他功能超链接 -->
	<div id="TableTail" align="center">
		<div class="FunctionButton"><a href="/dish?method=saveui">添加</a></div>
    </div> 
</div>
</body>
</html>
