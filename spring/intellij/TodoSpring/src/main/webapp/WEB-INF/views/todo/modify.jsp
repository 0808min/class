<%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-11-11
  Time: 오전 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
    <style>

    </style>
</head>
<body>

<h1>Todo Modify</h1>
<form method="post">
    <table>
        <tr>
            <td>번호</td>
            <td><input type="text" name="tno" value="${param.tno}" readonly></td>
        </tr>
        <tr>
            <td>할일 </td>
            <td><input type="text" name="todo" value="${todo.todo}" > </td>
        </tr>
        <tr>
            <td>기한 </td>
            <td><input type="date" name="dueDate" value="${todo.dueDate}" > </td>
        </tr>
        <tr>
            <td>상태 </td>
            <td><input type="checkbox" name="finished" value="1" ${todo.finished ? 'checked' : ''} > </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="reset">
                <input type="submit" value="Modify">
            </td>
        </tr>
    </table>
</form>

<form action="/todo/remove" method="post">
    <input type="hidden" name="tno" value="${param.tno}">
    <input type="submit" value="Remove">
</form>

    <a href="/todo/list">Todo List</a>

</body>
</html>
