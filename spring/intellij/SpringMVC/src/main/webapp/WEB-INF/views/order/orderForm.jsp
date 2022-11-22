<%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-11-21
  Time: 오전 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

  <h1>주문</h1>

  <form method="post">

    <h3>삼품 1</h3>
    ID - <input type="text" name="orderItems[0].itemId" > <br>
    개수 - <input type="number" name="orderItems[0].number"> <br>
    주의 - <input type="text" name="orderItems[0].remark">

    <h3>삼품 2</h3>
    ID - <input type="text" name="orderItems[1].itemId" > <br>
    개수 - <input type="number" name="orderItems[1].number"> <br>
    주의 - <input type="text" name="orderItems[1].remark">

    <h3>삼품 3</h3>
    ID - <input type="text" name="orderItems[2].itemId" > <br>
    개수 - <input type="number" name="orderItems[2].number"> <br>
    주의 - <input type="text" name="orderItems[2].remark">

    <h3>배송지 주소</h3>
    우편번호 - <input type="text" name="address.zipcode"> <br>
    주소1 - <input type="text" name="address.address1"> <br>
    주소2 - <input type="text" name="address.address2"> <br>

    <br>

    <input type="submit">

  </form>

</body>
</html>
