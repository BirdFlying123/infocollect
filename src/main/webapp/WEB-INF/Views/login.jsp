<%--
  Created by IntelliJ IDEA.
  User: 我
  Date: 2017/11/13
  Time: 13:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form action="/admin/login.do" method="post">
    username<input type="text" name="username" value="${param.username}">
    ${requestScope.loginMessage}<br/>

    password<input type="password" name="password" ><br/>

    <input type="submit" value="提交">
</form>

</body>
</html>
