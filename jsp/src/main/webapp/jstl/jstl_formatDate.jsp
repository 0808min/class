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
<%
    request.setAttribute("now", new Date());
%>

${now}

<hr>

<h3>날짜</h3>

<fmt:formatDate value="${now}"/> <br>

<fmt:formatDate value="${now}" type="date"/> <br>

<fmt:formatDate value="${now}" type="date" dateStyle="full"/> <br>
<fmt:formatDate value="${now}" type="date" dateStyle="short"/> <br>

<h3>시간</h3>

<fmt:formatDate value="${now}" type="time"/> <br>

<fmt:formatDate value="${now}" type="time" timeStyle="full"/> <br>
<fmt:formatDate value="${now}" type="time" timeStyle="short"/> <br>

<h3>both</h3>

<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/> <br>

<h3>패턴</h3>

<fmt:formatDate value="${now}" pattern="yyyy. MM. dd. HH:mm:ss"/> <br>

<hr>






</body>
</html>
