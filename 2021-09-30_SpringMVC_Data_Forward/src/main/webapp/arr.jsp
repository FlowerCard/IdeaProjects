<%--
  Created by IntelliJ IDEA.
  User: ASUA
  Date: 2021/10/1
  Time: 7:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
    <body>
        <form action="${pageContext.request.contextPath}/param/p07">
            爱好：<br>
            篮球：<label>
                    <input type="checkbox" name="hobby" value="basketball"/>
                </label> <br> 
            RAP：<label> 
                    <input type="checkbox" name="hobby" value="rap" />
                </label> <br> 
            唱歌：<label> 
                    <input type="checkbox" name="hobby" value="singing"/>
                </label> <br> 
            跳舞：<label> 
                    <input type="checkbox" name="hobby" value="dancing" />
                </label> <br>
            <input type="submit" value="提交" />
        </form>
    </body>
</html>
