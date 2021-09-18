<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<!-- 包含公共的JSP代码片段 -->
	
<title>餐馆王平台</title>
<jsp:include page="./detail/resource/static_resouce.jsp"/>
<%--<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />--%>
<%--<script type="text/javascript" src="${front_detail_path}/style/js/jquery.js"></script>--%>
<%--<script type="text/javascript" src="${front_detail_path}/style/js/page_common.js"></script>--%>
<%--<link href="${front_detail_path}/style/css/common_style_blue.css" rel="stylesheet" type="text/css">--%>
<%--<link rel="stylesheet" type="text/css" href="${front_detail_path}/style/css/index_1.css" />--%>
	<style type="text/css">
	* {
		margin: 0px;
		padding: 0px
	}
	#dish_2 a{
		text-decoration:none;
		font-size:36px;
		color:#000;
	}
	#dish_2 ul { 
		list-style:none;
	} 
	#dish_2 li{
		background:url(${front_detail_path}style/images/img/btn.gif);
		width:164px;
		height:47px;
		text-align:center;
		padding-top:5px;
	}
	</style>
</head>
<body style="text-align: center">
	<!--外部的大层-->
	<div class="index_all" style="text-align:center;">
		<!--上面的背景层-->
		<div>
			<img src="${front_detail_path}/style/images/flower.gif" />
		</div>
		<!--中间层-->
		<div id="index_center">
			<!--中间层的空白层-->
			<div id="space">
				
			</div>
			<!--中间层的菜单层-->
			<div>
				<!--菜单层的左边-->
				<div id="index_centerleft"></div>
				<!--菜单层的中间-->
				<div class="bg_middle">
					<img
						src="${front_detail_path}/style/images/index_menu.gif"
						border="0" usemap="#Map" />
					<map name="Map" id="Map">
						<area shape="rect" coords="164,99,354,199" href="/front?method=search" />
					</map>
				</div>
				<!--中间层的右边-->
				<div id="index_centerright"></div>
			</div>

			<!--放桌子的层-->
			<div id="center_bottom">
				<ul style=" display:inline-table">
					
						<li>
							<a href="/front?method=search">
								点菜
							</a>
						</li>
					
				</ul>
			</div>
		</div>
		
		<!--下面的背景层-->
		<div>
			<img src="${front_detail_path}/style/images/flower.gif" />
		</div>
	</div>
</body>
</html>
<script>
	$(function (){
		$.get('/cuisine?method=queryAll',{},function (){
			
		},'json')
	})
</script>