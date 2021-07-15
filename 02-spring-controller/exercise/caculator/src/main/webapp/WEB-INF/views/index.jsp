<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 7/15/2021
  Time: 12:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Caculator</title>
</head>
<body>
<h1>Caculator</h1>

<form method="post" action="calculate">
    <fieldset>
        <legend>Calculator</legend>
        <table style="width: 60%">
            <tr>
                <td>First operand:</td>
                <td><input name="firstOperand" type="text"/></td>
            </tr>
            <tr>
                <td>Operator:</td>
                <td><input type="text" name="operator" id="calculate" disabled></td>
                <td><input onclick="choose('+')" type="button" value="+">Addition
                    <input onclick="choose('-')" type="button" value="-">Subtraction
                    <input onclick="choose('*')" type="button" value="*">Multiplication
                    <input onclick="choose('/')" type="button" value="/">Division
                </td>
            </tr>
            <tr>
                <td>Second operand:</td>
                <td><input name="secondOperand" type="text"/></td>
            </tr>
            <tr>
                <td><input onclick="submit()" type="submit" value="Calculate"/></td>
            </tr>
        </table>
    </fieldset>
</form>
<p> Result : </p>
<p style="color: red">${result}</p>
<script>
    function choose(x) {
        document.getElementById("calculate").value = x;
                document.getElementById("calculate").disabled = false;
    }
</script>
<%--<script>--%>
<%--    function submit() {--%>
<%--        document.getElementById("calculate").disabled = false;--%>
<%--    }--%>
<%--</script>--%>
</body>
</html>
