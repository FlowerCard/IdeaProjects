<%--
  Created by IntelliJ IDEA.
  User: Dushine2008
  Date: 2021/8/25
  Time: 14:31
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
    </head>
    <body>
        <table class="layui-hide" id="test" lay-filter="test"></table>
        <script type="text/html" id="toolbarDemo">
            <div class="layui-btn-container">
                <button class="layui-btn layui-btn-sm" lay-event="getCheckData">获取选中行数据</button>
                <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>
                <button class="layui-btn layui-btn-sm" lay-event="isAll">验证是否全选</button>
            </div>
        </script>

        <script type="text/html" id="barDemo">
<%--            <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>--%>
<%--            <a class="layui-btn layui-btn-xs layui-btn-xs" lay-event="in">入库</a>--%>
<%--            <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="out">出库</a>--%>
            <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
        </script>

        <script>
            layui.use(['table','layer'], function(){
                var table = layui.table;
                var layer = layui.layer;

                table.render({
                    elem: '#test'
                    ,url:'http://localhost/record/getAll'
                    ,toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
                    ,defaultToolbar: ['filter', 'exports', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
                        title: '提示'
                        ,layEvent: 'LAYTABLE_TIPS'
                        ,icon: 'layui-icon-tips'
                    }]
                    ,parseData:function(result){
                        return {
                            'code':0,
                            'msg':result.message,
                            'count':result.count,
                            'data':result.data
                        }
                    }
                    ,title: '用户数据表'
                    ,cols: [[
                        {type: 'checkbox', fixed: 'left'}
                        ,{field:'id', title:'ID', width:80, fixed: 'left', unresize: true, sort: true}
                        ,{field:'userId', title:'操作者ID', width:120, edit: 'text'}
                        ,{field:'goodsName', title:'商品名称', width:200, edit: 'text'}
                        ,{field:'operationType', title:'操作类型', width:120, edit: 'text', sort: true ,templet:function (res){
                                if (res.operationType == -1){
                                    return "出库";
                                } else if (res.operationType == 1) {
                                    return "入库";
                                } else {
                                    return "异常";
                                }
                            }}
                        ,{field:'operationNum', title:'操作数量', width:150}
                        ,{field:'operationTime', title:'记录时间', width:500}
                        ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:100}
                    ]]
                    ,page: true
                });

                //头工具栏事件
                table.on('toolbar(test)', function(obj){
                    var checkStatus = table.checkStatus(obj.config.id);
                    switch(obj.event){
                        case 'getCheckData':
                            var data = checkStatus.data;
                            layer.alert(JSON.stringify(data));
                            break;
                        case 'getCheckLength':
                            var data = checkStatus.data;
                            layer.msg('选中了：'+ data.length + ' 个');
                            break;
                        case 'isAll':
                            layer.msg(checkStatus.isAll ? '全选': '未全选');
                            break;
                        case 'addGoods':
                            location.href="addGoods.jsp";
                            break;

                        //自定义头工具栏右侧图标 - 提示
                        case 'LAYTABLE_TIPS':
                            layer.alert('这是工具栏右侧自定义的一个图标按钮');
                            break;
                    };
                });

                //监听行工具事件
                table.on('tool(test)', function(obj){
                    var data = obj.data;
                    if(obj.event === 'del'){
                        layer.confirm('真的删除行么', function(index){
                            $.ajax({
                                url:"http://localhost/record/deleteRecord?id=" + data.id,
                                type:"delete",
                                dataType:"json",
                                contentType:"application/json",
                                success:function (ret) {
                                    if (ret.code == 0){
                                        // obj.del();
                                        alert("删除成功");
                                        layer.close(index);
                                        window.location.href("userList.jsp")
                                    }else{
                                        alert("删除失败,请重试...");
                                        layer.close(index);
                                    }
                                }
                            })
                        });
                    } else if(obj.event === 'edit'){
                        location.href="updateGoods.jsp?id=" + data.id;
                    } else if (obj.event === 'out') {
                        location.href="outGoods.jsp?id=" + data.id;
                    } else if (obj.event === 'in') {
                        location.href="inGoods.jsp?id=" + data.id;
                    }
                });
            });
        </script>
    </body>
</html>
