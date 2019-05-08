<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: andrii
  Date: 5/2/19
  Time: 6:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Beer</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
<%--All beer form--%>
<div>
    <table class="table table-striped">
        <thead>
        <tr>
            <th> Beer id</th>
            <th> Beer Name</th>
            <th> Alcohol Percent</th>
        </tr>
        </thead>
        <c:forEach items="${beerList}" var="beer">
            <tbody>
            <tr>
                <td>${beer.id}</td>
                <td>${beer.name}</td>
                <td>${beer.alcoholPercent}</td>
            </tr>
            </tbody>
        </c:forEach>
    </table>
</div>
<form action="/beer" method="post">
    <input type="text" name="name" placeholder="name">
    <input type="text" name="alcoholPercent" placeholder="alcohol Percent">
    <input type="submit" value="ADD">
</form>
<%--<script>--%>
<%--    hello();--%>
<%--    alert("alert1");--%>

<%--    function hello() {--%>
<%--        alert("Hello function js!1");--%>
<%--    }--%>
<%--</script>--%>
<%--<script type="text/javascript" src="js/index.js"/>--%>
<%--<script src="${index.js}"></script>--%>
</body>
</html>
