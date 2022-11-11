<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-11-09
  Time: 오후 2:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<c:set var="number" value="100000000"/>

숫자 : <fmt:formatNumber value="${number}"/> <br>
통화 : <fmt:formatNumber value="${number}" type="currency"/> <br>
통화 : <fmt:formatNumber value="${number}" type="currency" currencySymbol="$"/> <br>
퍼센트 : <fmt:formatNumber value="${number/4000000000}" type="percent"/> <br>
패턴 : <fmt:formatNumber value="${number}" pattern="000,000.00"/> <br>


</body>
</html>
