<%--
  Created by IntelliJ IDEA.
  User: Demyd
  Date: 25.02.2025
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>Історія ігор</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-5">
<h2>Історія ігор</h2>
<ul class="list-group">
    <%
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("gameHistory")) {
    %>
    <li class="list-group-item"><%= cookie.getValue() %></li>
    <%
                }
            }
        }
    %>
</ul>
<a href="index.jsp" class="btn btn-primary mt-3">Назад</a>
</body>
</html>
