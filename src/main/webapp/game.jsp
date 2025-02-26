<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.quest.QuestState" %>

<%
    // Отримуємо стан гри з сесії
    QuestState state = (QuestState) session.getAttribute("questState");

    // Якщо гри ще немає, створюємо нову
    if (state == null) {
        state = new QuestState();
        session.setAttribute("questState", state);
    }
%>

<html>
<head>
    <title>Гра</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-5">
<h2 class="mb-4">Квест</h2>
<p class="lead"><%= state.getCurrentText() %></p>

<% if (!state.isGameOver()) { %>
<form action="QuestServlet" method="post" class="mt-3">
    <button type="submit" name="choice" value="1" class="btn btn-success">Варіант 1</button>
    <button type="submit" name="choice" value="2" class="btn btn-danger">Варіант 2</button>
</form>
<% } else { %>
<h2>Гра завершена!</h2>
<form action="restart" method="post">
    <button type="submit" class="btn btn-primary">Почати заново</button>
</form>
<% } %>

<a href="history.jsp" class="btn btn-secondary mt-3">Переглянути історію</a>
</body>
</html>
