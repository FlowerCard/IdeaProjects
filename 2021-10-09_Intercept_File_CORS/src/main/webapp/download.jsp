<%--
  Created by IntelliJ IDEA.
  User: ASUA
  Date: 2021/10/9
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Download</title>
    </head>
    <body>
        <c:forEach begin="0" items="${fileList}" var="files">
            <a href="${pageContext.request.contextPath}/file/download?name=${files}">
                <img src="${pageContext.request.contextPath}/files/${files}" height="400px" />
            </a>
        </c:forEach>
    </body>
</html>
