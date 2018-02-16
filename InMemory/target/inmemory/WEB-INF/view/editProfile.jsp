<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: patel
  Date: 14/2/18
  Time: 2:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/editProfile" method="post" modelAttribute="">
    <form:input path="fname"/>
    <form:input path="lname"/>
    <form:input path="contact"/>
    <input type="submit" value="save">
</form:form>
</body>
</html>
