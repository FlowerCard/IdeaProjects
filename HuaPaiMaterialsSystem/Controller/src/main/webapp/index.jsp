<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>花牌物料管理系统</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/layui/2.6.8/css/layui.css" media="all">
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo layui-hide-xs layui-bg-black">花牌物料管理系统</div>
        
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item layui-hide layui-show-md-inline-block">
                <a href="javascript:;">
                    <img src="//tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" class="layui-nav-img">
                    ${userInfo.nickname}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="http://localhost/users/userInfo.jsp?id=${userInfo.id}" target="body">个人信息</a></dd>
                    <dd><a href="">设置</a></dd>
                    <dd><a href="http://localhost/users/signOut">登出</a></dd>
                </dl>
            </li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">用户管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="users/userList.jsp" target="body">用户列表</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">物料管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="goods/goodsList.jsp" target="body">商品列表</a></dd>
                        <dd><a href="record/recordList.jsp" target="body">出入库记录</a></dd>
                        <dd><a href="type/goodsTypeList.jsp" target="body">商品类型列表</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
<%--        <div style="padding: 15px;">内容主体区域。记得修改 layui.css 和 js 的路径</div>--%>
        <iframe name="body" src="main.jsp" width="100%" height="830px"></iframe>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
    </div>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/layui/2.6.8/layui.js" charset="utf-8"></script>
<script src="js/jquery-3.4.1.min.js" charset="utf-8"></script>
<script>
    
    //JS 
    layui.use(['element', 'layer', 'util'], function(){
        var element = layui.element
            ,layer = layui.layer
            ,util = layui.util
            ,$ = layui.$;

        //头部事件
        util.event('lay-header-event', {
            //左侧菜单事件
            menuLeft: function(othis){
                layer.msg('展开左侧菜单的操作', {icon: 0});
            }
            ,menuRight: function(){
                layer.open({
                    type: 1
                    ,content: '<div style="padding: 15px;">处理右侧面板的操作</div>'
                    ,area: ['260px', '100%']
                    ,offset: 'rt' //右上角
                    ,anim: 5
                    ,shadeClose: true
                });
            }
        });

    });
</script>
</body>
</html>