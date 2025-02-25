<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.quest.QuestState" %>
<%
    QuestState state = (QuestState) session.getAttribute("questState");
    if (state == null) response.sendRedirect("index.jsp");
%>
<html>
<head>
    <title>Quest</title>
</head>
<body>
<h2>Твій вибір:</h2>
<% if (state.getCurrentStep().equals("start")) { %>
<p>Ти прокинувся у темному місті. Куди підеш?</p>
<form action="quest" method="post">
    <button type="submit" name="choice" value="A">Магазин</button>
    <button type="submit" name="choice" value="B">Алея</button>
</form>
<% } else if (state.getCurrentStep().equals("shop")) { %>
<p>Ти у магазині. Далі?</p>
<form action="quest" method="post">
    <button type="submit" name="choice" value="A">Метро</button>
    <button type="submit" name="choice" value="B">Поліція</button>
</form>
<% } else { %>
<p>Ти йдеш далі...</p>
<% } %>
</body>
</html>
