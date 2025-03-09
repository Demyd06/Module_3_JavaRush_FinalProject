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
    <style>
        body {
            background: url('https://source.unsplash.com/1600x900/?forest,mystery') no-repeat center center fixed;
            background-size: cover;
            color: white;
            text-shadow: 2px 2px 10px rgba(0, 0, 0, 0.8);
            font-family: 'Georgia', serif;
            background-color: dimgrey;
        }
    </style>
</head>
<body>
<h2><%= state.getResult() %></h2>
<form action="index.jsp">
    <button type="submit">Почати спочатку</button>
</form>
</body>
</html>

