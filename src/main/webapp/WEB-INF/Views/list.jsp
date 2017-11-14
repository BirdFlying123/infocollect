<%--
  Created by IntelliJ IDEA.
  User: 我
  Date: 2017/11/13
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>list</title>
</head>
<body>
<table border="1">
    <tr>
        <th>id</th>
        <th>邮箱</th>
        <th>组织</th>
        <th>创建时间</th>
        <th>是否验证</th>
        <th>修改验证状态</th>
    </tr>
    <%--<c:if test="${not requestScope.result}">--%>
    <c:forEach items="${requestScope.backUserInfos}" var="backUserInfos">
        <tr>
            <td>${backUserInfos.id}</td>
            <td>${backUserInfos.email}</td>
            <td>${backUserInfos.institution}</td>
            <td>${backUserInfos.createtime}</td>
            <td>${backUserInfos.ifChecked}</td>
            <th><a href="/admin/change/${backUserInfos.id}">修改</a></th>
        </tr>
    </c:forEach>
    <%--</c:if>--%>

</table>


</body>
</html>
