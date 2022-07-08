<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 06.07.2022
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">

</head>
<body>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Name</th>
        <th scope="col">Login</th>
        <th scope="col">Email</th>
    </tr>
    </thead>
    <tbody>
    <%--@elvariable id="users" type="java.util.List"--%>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.name}</td>
            <td>${user.login}</td>
            <td>${user.email}</td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>

