<%--
  Created by IntelliJ IDEA.
  User: ASUA
  Date: 2021/10/9
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Upload</title>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/file/upload" method="post" enctype="multipart/form-data">
            文件上传：<input type="file" name="source" />
            <br>
            <input type="submit" value="上传"/>
        </form>
    </body>
</html>
