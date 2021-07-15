<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 7/15/2021
  Time: 12:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sandwich</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="save" method="post">
    <input type="checkbox" name="condiment" value="Lettuce">Lettuce
    <input type="checkbox" name="condiment" value="Tomato">Tomato
    <input type="checkbox" name="condiment" value="Mustard">Mustard
    <input type="checkbox" name="condiment" value="Sprouts">Sprouts
    <hr>
    <input type="submit" value="Save">
</form>
<p> Result : </p>
<c:forEach items="${result}" var="spice">
    <p style="color: red">${spice}</p>
</c:forEach>
</body>
</html>
