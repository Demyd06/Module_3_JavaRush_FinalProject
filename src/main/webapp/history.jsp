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
<h2>Історія ігор</h2>

<p><strong>Wins:</strong> <%= wins %></p>
<p><strong>Losses:</strong> <%= losses %></p>

<% if (history == null && history.isEmpty()) { %>
    <p>Поки що немає завершених ігор.</p>
<% } %>

<a href="index.jsp" class="btn btn-primary mt-3">Назад</a>
</body>
</html>
