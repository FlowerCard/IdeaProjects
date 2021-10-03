<%--
  Created by IntelliJ IDEA.
  User: ASUA
  Date: 2021/10/2
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.4.1.min.js"></script>
</head>
    <body>
        <input type="button" value="Ajax请求" id="ajaxBtn" />
        <script>
            $("#ajaxBtn").click(function (){
                var obj = {};
                obj.id="10001";
                obj.username="张三";
                obj.password="san";
                obj.birth="2020-08-09";
                
                $.ajax({
                    url:"ajax/user03",
                    type:"post",
                    // 请求头
                    // headers:{
                    //     token:"10001"
                    // },
                    contentType:"application/json",
                    data:JSON.stringify(obj),
                    // data:obj,
                    success:function (res){
                        console.log(res);
                    }
                })
            })
        </script>
    </body>
</html>
