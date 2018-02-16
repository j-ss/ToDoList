<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: patel
  Date: 14/2/18
  Time: 2:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>Welcome</h2>

<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="post">
    <c:if test="${parm.error!=null}">
        invalid username and password
    </c:if>
    <c:if test="${parm.logout!=null}">
        successful logout
    </c:if>

    <input type="text" name="username" placeholder="username">
    <input type="password" name="password" placeholder="password">
    <input type="submit" value="login">
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}" />
</form:form>

<a href="/register">SignUp</a>
</body>
</html>
