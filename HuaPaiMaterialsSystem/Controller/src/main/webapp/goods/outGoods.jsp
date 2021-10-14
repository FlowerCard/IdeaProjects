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
                    type:"get",
                    url:"http://localhost/goods/getGoods?id=" + ${pageContext.request.getParameter("id")},
                    dataType:"json",
                    success:function (ret) {
                        $("#id").val(ret.id);
                        $("#goodsId").val(ret.goodsId);
                        $("#goodsName").val(ret.goodsName);
                        $("#goodsPrice").val(ret.goodsPrice);
                        $("#goodsType").val(ret.goodsType);
                        $("#goodsInfo").val(ret.goodsInfo);
                    }
                })
            })
        </script>

    </head>
    <body>
        <div id="box" class="container">
            <!-- 商品类型表单 -->
            <form action="http://localhost/goods/outGoods" method="post">
                <h1 style="text-align: center;font-weight: 400;font-size: 24px">修改商品</h1>
                <br>
                <br>

                <div class="layui-form-item" hidden="hidden">
                    <label class="layui-form-label">
                        ID
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" name="id" id="id" required lay-verify="id" autocomplete="off"
                               class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux">id不可以修改</div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">
                        商品编号
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" name="goodsId" id="goodsId" required lay-verify="goodsId" placeholder="请输入商品编号" autocomplete="off"
                               class="layui-input" readonly>
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">商品名称</label>
                    <div class="layui-input-inline">
                        <input type="text" name="goodsName" id="goodsName" required lay-verify="goodsName" placeholder="请输入商品名称" autocomplete="off"
                               class="layui-input" readonly>
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">出库数量</label>
                    <div class="layui-input-inline">
                        <input type="text" name="outNum" id="outNum" required lay-verify="outNum" placeholder="请输入出库数量" autocomplete="off"
                               class="layui-input">
                    </div>
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

