<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: patel
  Date: 13/2/18
  Time: 2:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .error{color: red}
    </style>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/registerUser" method="post" modelAttribute="userdetail">
    <label>FirstName</label>
    <form:input path="firstName"/>
    <form:errors path="firstName" cssClass="error"/>
    <label>LastName</label>
    <form:input path="lastName"/>
    <form:errors path="lastName" cssClass="error"/>
    <label>UserName</label>
    <form:input path="userName"/>
    <form:errors path="userName" cssClass="error"/>
    <label>Password</label>
    <form:input path="password"/>
    <form:errors path="password" cssClass="error"/>
    <label>Contact</label>
    <form:input path="contact"/>
    <%--<form:errors path="contact" cssClass="error"/>--%>
    <input type="submit" value="register">
</form:form>
</body>
</html>
