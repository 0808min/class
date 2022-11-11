<%@ page import="java.util.List" %>
<%@ page import="com.example.test.member.Member" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-11-09
  Time: 오후 2:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
  List<Member> members = new ArrayList<>();
  members.add(new Member("cool00", "1110", "COOL0"));
  members.add(new Member("cool01", "1111", null));
  members.add(new Member("cool02", "1112", "COOL0"));
  members.add(new Member("cool03", "1113", "COOL0"));
  members.add(new Member("cool04", "1114", null));
  members.add(new Member("cool05", "1115", null));
  members.add(new Member("cool06", "1116", "COOL0"));
  members.add(new Member("cool07", "1117", "COOL0"));
  members.add(new Member("cool08", "1118", null));
  members.add(new Member("cool09", "1119", "COOL0"));

  session.setAttribute("members", members);


%>

</body>
</html>
