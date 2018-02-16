<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: patel
  Date: 14/2/18
  Time: 2:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
First Name:${profile.fname}<br>
Last Name :${profile.lname}<br>
contact&nbsp;:${profile.contact}<br>
UserName:${profile.username}
<a href="/edit">edit</a>
</body>
</html>
