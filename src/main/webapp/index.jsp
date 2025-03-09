<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Легенда про Загублений Скарб</title>
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
        .container {
            max-width: 800px;
            background: rgba(0, 0, 0, 0.7);
            padding: 30px;
            border-radius: 10px;
            margin-top: 50px;
        }
        h1 {
            font-size: 2.5rem;
            font-weight: bold;
            text-align: center;
        }
        .lead {
            font-size: 1.3rem;
            text-align: justify;
            margin-bottom: 20px;
        }
        .btn-start {
            display: block;
            width: 50%;
            margin: 20px auto;
            padding: 12px;
            font-size: 22px;
            font-weight: bold;
            color: white;
            background: linear-gradient(45deg, #007bff, #0056b3);
            border: none;
            border-radius: 8px;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.5);
            transition: 0.3s;
        }
        .btn-start:hover {
            background: linear-gradient(45deg, #0056b3, #003d80);
            transform: scale(1.05);
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Легенда про Загублений Скарб</h1>
    <p class="lead">
        Десь у глибинах древнього лісу прихований безцінний скарб, про який ходять легенди.
        Лише обрані можуть знайти його, подолавши небезпечні шляхи та смертельні пастки.
        Ви – шукач пригод, який наважився пройти цей шлях.
    </p>
    <p class="lead">
        Перед вами три дороги: одна веде в темний ліс, інша – у зловісну печеру, а третя – до загадкової річки.
        Кожен вибір може стати вашим останнім… або принести вам найбільший скарб усього життя.
    </p>

    <form action="game.jsp">
        <button type="submit" class="btn btn-start">Почати гру</button>
    </form>
</div>
</body>
</html>
