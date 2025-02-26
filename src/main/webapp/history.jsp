<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>

<%
    List<String> history = (List<String>) session.getAttribute("gameHistory");
    Integer wins = (Integer) session.getAttribute("wins");
    Integer losses = (Integer) session.getAttribute("losses");

    if (wins == null) wins = 0;
    if (losses == null) losses = 0;
%>

<html>
<head>
    <title>Історія ігор</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-5">
<h2>Історія ігор</h2>

<p><strong>Wins:</strong> <%= wins %></p>
<p><strong>Losses:</strong> <%= losses %></p>

<% if (history != null && !history.isEmpty()) { %>
<ul class="list-group">
    <% for (String entry : history) { %>
    <li class="list-group-item"><%= entry %></li>
    <% } %>
</ul>
<% } else { %>
<p>Поки що немає завершених ігор.</p>
<% } %>

<a href="index.jsp" class="btn btn-primary mt-3">Назад</a>
</body>
</html>
