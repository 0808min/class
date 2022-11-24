<%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-11-24
  Time: 오후 2:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>부서 등록</h1>
<hr>
<form method="post">

    <table>
        <tr>
            <td>부서번호</td>
            <td><input type="number" name="deptno" ></td>
        </tr>
        <tr>
            <td>부서이름</td>
            <td><input type="text" name="dname"></td>
        </tr>
        <tr>
            <td>부서지역</td>
            <td><input type="text" name="loc"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="등록"> </td>
        </tr>
    </table>

</form>

</body>
</html>
