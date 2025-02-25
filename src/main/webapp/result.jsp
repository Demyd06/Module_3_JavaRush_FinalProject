<%--
  Created by IntelliJ IDEA.
  User: Demyd
  Date: 24.02.2025
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.quest.QuestState" %>
<%
    QuestState state = (QuestState) session.getAttribute("questState");
%>
<html>
<head>
    <title>Результат</title>
</head>
<body>
<h2><%= state.getResult() %></h2>
<form action="index.jsp">
    <button type="submit">Почати спочатку</button>
</form>
</body>
</html>

