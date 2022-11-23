<%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-11-21
  Time: 오후 2:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>과제 제출 3</h1>
<form action="/report/submit3" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>학번</td>
            <td><input type="text" name="snum"></td>
        </tr>
        <tr>
            <td>이름</td>
            <td><input type="text" name="sname"></td>
        </tr>
        <tr>
            <td>리포트 파일</td>
            <td>
                <input type="file" name="report">
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="제출"></td>
        </tr>
    </table>

</form>

<hr>


<h1>과제 제출 2</h1>
<form action="/report/submit2" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>학번</td>
            <td><input type="text" name="snum"></td>
        </tr>
        <tr>
            <td>이름</td>
            <td><input type="text" name="sname"></td>
        </tr>
        <tr>
            <td>리포트 파일</td>
            <td>
                <input type="file" name="report">
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="제출"></td>
        </tr>
    </table>

</form>

<hr>

<h1>과제 제출 1</h1>
<form action="/report/submit1" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>학번</td>
            <td><input type="text" name="snum"></td>
        </tr>
        <tr>
            <td>이름</td>
            <td><input type="text" name="sname"></td>
        </tr>
        <tr>
            <td>리포트 파일</td>
            <td>
                <input type="file" name="report">
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="제출"></td>
        </tr>
    </table>

</form>
</body>
</html>
