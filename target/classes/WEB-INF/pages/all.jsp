<%--
  Created by IntelliJ IDEA.
  User: 33558
  Date: 15.03.2017
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Archive</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
<h3 align="center"><img height="40" src="<c:url value="/static/google sites-icon-large.png" />"></h3>
<p align="center"><a href="/">Download File to Archive</a></p>
</div align="center">
<div>
    <table class="table table-striped">
        <thead>
        <tr>
            <th> Archive id</th>
            <th> Created Date</th>
            <th> Archive Name</th>
            <th> Download</th>
            <th> Delete</th>
        </tr>
        </thead>
        <c:forEach items="${list}" var="box">
            <tbody>
            <tr>
                <td>${box.id}</td>
                <td>${box.date}</td>
                <td>${box.name}</td>
                <td><input type="image" height="20" src="/static/open_box.png" name="submit"
                           onclick="window.location='/download/${box.id}';"></td>
                <td><input type="image" height="20" src="/static/dell.png" name="submit"
                           onclick="window.location='/dell/${box.id}';"></td>
            </tr>
            </tbody>
        </c:forEach>
    </table>

    <br>
    <a href="/beer">To beer Page</a>
</div>
</body>
</html>
