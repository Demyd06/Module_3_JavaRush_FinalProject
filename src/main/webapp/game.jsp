<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.quest.QuestState" %>
<%
    QuestState state = (QuestState) session.getAttribute("questState");
    if (state == null) {
        state = new QuestState();
        session.setAttribute("questState", state);
    }
%>
<html>
<head>
    <title>Гра</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
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
<body class="container mt-5">
<h2 class="mb-4 text-center">🔹 Квестова гра 🔹</h2>
<p class="lead text-center"><%= state.getCurrentText() %></p>

<% if (!state.isGameOver()) { %>
<form action="QuestServlet" method="post" class="text-center mt-3">
    <button type="submit" name="choice" value="1" class="btn btn-primary">Варіант 1</button>
    <button type="submit" name="choice" value="2" class="btn btn-warning">Варіант 2</button>
    <% if (state.getCurrentText().contains("три дороги")) { %>
    <button type="submit" name="choice" value="3" class="btn btn-success">Варіант 3</button>
    <% } %>
</form>
<% } else { %>
<h3 class="text-center"><%= state.getResult() %></h3>
<form action="restart" method="post" class="text-center">
    <button type="submit" class="btn btn-danger">Почати заново</button>
    <a href="history.jsp" class="btn btn-primary">Переглянути історію</a>
</form>
<% } %>

</body>
</html>
