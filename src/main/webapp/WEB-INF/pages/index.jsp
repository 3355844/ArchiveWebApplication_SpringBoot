<%--9
  Created by IntelliJ IDEA.
  User: 33558
  Date: 14.03.2017
  Time: 0:24
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
<div align="center">
    <h3><img height="40" src="<c:url value="/static/google sites-icon-large.png"/>">
    </h3>
    <p align="center"><a href="/all">Archive Files</a></p>
</div >
<div align="center">${mess}</div>
<div align="center">
    <form action="/add" name="form" method="post" enctype="multipart/form-data">
        <label for="file">File</label>
        <input type="file" name="file" id="file" value="Press and find File" placeholder="Files way"/>
        <br/>
        <input type="image" src="/static/to_box.png" name="submit" id="submit"/>
    </form>
</div>
<div>
    <a href="/beer">To beer Page</a>
</div>
</body>
</html>
