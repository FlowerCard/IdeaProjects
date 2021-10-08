<%--
  Created by IntelliJ IDEA.
  User: ASUA
  Date: 2021/10/8
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>jack01</title>
        <script src="js/jquery-3.4.1.min.js"></script>
    </head>
    <body>
        <button id="btn_getHero">获取英雄</button>
        <button id="btn_sendHero">发送英雄</button>
    </body>
</html>
<script>
    $("#btn_getHero").click(function (){
        $.ajax({
            method:"GET",
            url:"http://localhost:8080/fast/fast01",
            dataType:"JSON",
            success:function (res){
                console.log(res)
            }
        })
    })
    
    $("#btn_sendHero").click(function (){
        var hero = {};
        hero.id=1002;
        hero.username="hero02";
        hero.password="123";
        hero.birth="2010-11-21";
        hero.balance=123.123;
        $.ajax({
            method: "POST",
            url: "http://localhost:8080/fast/fast02",
            data: JSON.stringify(hero),
            contentType: "application/json",
            success:function (res){
                console.log(res)
            }
        })
    })
</script>
