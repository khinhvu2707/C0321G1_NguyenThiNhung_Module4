<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 7/14/2021
  Time: 10:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Currency Convert</h2>
<form action="/convert" method="post">
    <label>USD: </label><br/>
    <input type="text" name="usd" placeholder="USD"><br/>
    <label>Rate: </label><br/>
    <input type="text" name="rate" placeholder="Rate"><br/>
    <input type="submit" id="submit" value="Convert" style="margin-top: 5px">
</form>
</body>
</html>
