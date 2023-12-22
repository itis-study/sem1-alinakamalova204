<%--
  Created by IntelliJ IDEA.
  User: Алина Камалова
  Date: 03.11.2023
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SignIn</title>
</head>
<body style="background-color: #fdf8f4">
    <h1>Введите Ваше имя и придумайте пароль</h1>
    <form method="post" action="/signIn">

        <label for="firstName">Ваше имя:</label>
        <input type="text" name="firstName" id="firstName" required><br>
        <label for="lastName">Ваша фамилия:</label>
        <input type="text" name="lastName" id="lastName" required><br>
        <label for="password">Придумайте пароль:</label>
        <input type="password" name="password" id="password" required><br>

        <input type="submit" value="Зарегистрироавться">
    </form>
</body>
</html>
