<%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-11-21
  Time: 오전 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    ${orderCommand}

    <h1>주문 내역</h1>

    <c:forEach var="orderItem" items="${orderCommand.orderItems}" varStatus="stat">
    <h3> 상품 - ${stat.count}</h3>
    ID - ${orderItem.itemId}<br>
    개수 - ${orderItem.number} <br>
    주의사항 - ${orderItem.remark} <br>
    </c:forEach>

    <h3>배송지</h3>
    우편번호 - ${orderCommand.address.zipcode} <br>
    주소1 - ${orderCommand.address.address1} <br>
    주소2 - ${orderCommand.address.address2}

</body>
</html>
