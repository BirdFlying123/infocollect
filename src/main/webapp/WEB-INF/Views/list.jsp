<%--
  Created by IntelliJ IDEA.
  User: 我
  Date: 2017/11/13
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>list</title>
    <style type="text/css">
        .table, .table * {margin: 0 auto; padding: 0;font-size: 14px;font-family: Arial, 宋体, Helvetica, sans-serif;}
        .table {display: table; width: 80%; border-collapse: collapse;}
        .table-tr {display: table-row; height: 30px;}
        .table-th {display: table-cell;font-weight: bold;height: 100%;border: 1px solid gray;text-align: center;vertical-align: middle;background-color:#E5E5E5;}
        .table-td {display: table-cell; height: 100%;border: 1px solid gray; text-align: center;vertical-align: middle;}
    </style>
</head>
<body BGCOLOR="#CCCCCC">
<br/><br/><br/><br/>
<div class="table">
    <div class="table-tr">
        <div class="table-th">id</div>
        <div class="table-th">邮箱</div>
        <div class="table-th">单位</div>
        <div class="table-th">是否验证</div>
        <div class="table-th">修改验证状态</div>
    </div>

    <c:forEach items="${requestScope.backUserInfos}" var="backUserInfos">
    <div class="table-tr">
        <div class="table-td">${backUserInfos.id}</div>
        <div class="table-td">${backUserInfos.email}</div>
        <div class="table-td">${backUserInfos.institution}</div>
        <div class="table-td">${backUserInfos.ifChecked}</div>
        <div class="table-td"><a href="/admin/change/${backUserInfos.id}">修改</a></div>
    </div>
    </c:forEach>
</div>
</body>
</html>