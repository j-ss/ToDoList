<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: patel
  Date: 14/2/18
  Time: 5:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .text-area{
            width: 100vw;
            height: 100vh;
            border: hidden;
        }
    </style>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/todo" method="post" modelAttribute="todo">
<form:textarea path="text" cssClass="text-area"/>

    <input type="checkbox" name="encryption" value="encrypt" >Encrypt</input>

    <input type="submit" value="save">
</form:form>
</body>
</html>
