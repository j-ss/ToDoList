<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="javax.management.Query" %>
<%@ page import="org.springframework.beans.factory.annotation.Autowired" %>
<%@ page import="com.spring.dao.ToDoDao" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: patel
  Date: 14/2/18
  Time: 2:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

hello

<form:form action="${pageContext.request.contextPath}/logout"
           method="POST">

    <input type="submit" value="Logout" />

</form:form>

<%

%>
<a href="/create">New</a>
</body>
</html>
