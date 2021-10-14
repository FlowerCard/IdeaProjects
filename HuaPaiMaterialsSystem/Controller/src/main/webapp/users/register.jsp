<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>注册</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/layui/2.6.8/css/layui.css" media="all">
        <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
        <style>
            #userDiv{
                width: 500px;
                margin-top: 15%;
                margin-left: 30%;
            }
    
            body{
                background-image: url("../img/register.jpg");
            }
            #regTitle{
                margin-left: 50%;
                margin-bottom: 20px;
                color: white;
            }
        </style>
    </head>
    <body>
    
    <!-- 示例-970 -->
    <!--
    <ins class="adsbygoogle"
    style="display:inline-block;width:970px;height:90px"
    data-ad-client="ca-pub-6111334333458862"
    data-ad-slot="3820120620"></ins>
    -->
    
    <div id="userDiv">
        
        <h2 id="regTitle">用户注册</h2>
        
        <form class="layui-form" action="http://localhost/users/register" method="post">
            <div class="layui-form-item">
                <label class="layui-form-label" style="color: white">用户名</label>
                <div class="layui-input-block">
                    <input type="text" name="username" lay-verify="title" autocomplete="off" placeholder="请输入用户名" class="layui-input" id="regName" />
                    <span id="hasName"></span>
                </div>
            </div>
            
            <div class="layui-form-item">
                <label class="layui-form-label"  style="color: white">密码</label>
                <div class="layui-input-block">
                    <input type="password" name="password" placeholder="请输入密码" autocomplete="off" class="layui-input" id="targetPassword">
                </div>
            </div>
            
            <div class="layui-form-item">
                <label class="layui-form-label"  style="color: white">确认密码</label>
                <div class="layui-input-block">
                    <input type="password" placeholder="请重复输入密码" autocomplete="off" class="layui-input" id="checkPassword">
                    <span id="rightPassword"></span>
                </div>
            </div>
    
            <div class="layui-form-item">
                <label class="layui-form-label"  style="color: white">昵称</label>
                <div class="layui-input-block">
                    <input type="text" name="nickname" placeholder="请输入昵称" autocomplete="off" class="layui-input">
                </div>
            </div>
    
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1" id="registerBtn">注册</button>
                    <button type="reset" class="layui-btn layui-btn-warm">重置</button>
                    <a href="http://localhost/users/login.jsp" class="layui-btn layui-btn-normal">登录</a>
                </div>
            </div>
        </form>
    </div>


    <script src="https://cdnjs.cloudflare.com/ajax/libs/layui/2.6.8/layui.js" charset="utf-8"></script>
    <script src="../js/jquery-3.4.1.min.js" charset="utf-8"></script>
    <!-- 注意：如果你直接复制所有代码到本地，上述 JS 路径需要改成你本地的 -->
    <script>
    
        $("#regName").change(function (){
            var name = $("#regName").val()
            $.get("http://localhost/users/users/" + name,function (res){
                console.log(res)
                if (!res){
                    $("#hasName").html("<span style='color: red'>用户存在</span>")
                    $("#registerBtn").attr("disabled",true)
                } else {
                    $("#hasName").html("<span style='color: green'>用户可用</span>")
                    $("#registerBtn").attr("disabled",false)
                }
            })
        })
        
        $("#checkPassword").change(function (){
            var target = $("#targetPassword").val();
            var check = $("#checkPassword").val();
            if (target !== check){
                $("#rightPassword").html("<span style='color: red'>两次密码不一致，请检查</span>")
                $("#registerBtn").attr("disabled",true)
            }
        })
        
        layui.use(['form', 'layedit', 'laydate'], function(){
            var form = layui.form
                ,layer = layui.layer
                ,layedit = layui.layedit
                ,laydate = layui.laydate;
    
            //日期
            laydate.render({
                elem: '#date'
            });
            laydate.render({
                elem: '#date1'
            });
    
            //创建一个编辑器
            var editIndex = layedit.build('LAY_demo_editor');
    
            //自定义验证规则
            form.verify({
                title: function(value){
                    if(value.length == ""){
                        return '标题至少得5个字符啊';
                    }
                }
                ,pass: [
                    /^[\S]{6,12}$/
                    ,'密码必须6到12位，且不能出现空格'
                ]
                ,content: function(value){
                    layedit.sync(editIndex);
                }
            });
    
            //监听提交
            form.on('submit(demo1)', function(data){
                // layer.alert(JSON.stringify(data.field), {
                //     title: '最终的提交信息'
                // })
                // return false;
            });
    
        });
    </script>
    
    </body>
</html>