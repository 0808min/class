<%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-11-21
  Time: 오후 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

  <div>
  인기검색어 :
      <c:forEach items="${keywords}" var="keyword" >
        ${keyword}
      </c:forEach>
  </div>

  <div>
    검색
    <select>

        <c:forEach items="${searchType}" var="type">
        <option>${type}</option>
        </c:forEach>

    </select>
    <input type="text">
    <input type="submit" value="검색">

  </div>


</body>
</html>
