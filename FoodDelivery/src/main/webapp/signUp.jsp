<%--
  Created by IntelliJ IDEA.
  User: Алина Камалова
  Date: 04.11.2023
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
</head>
<body style="background-color: #fdf8f4">
<h1>Введите Ваше имя и пароль</h1>
<form method="post" action="/signIn">

  <label for="firstName">Ваше имя:</label>
  <input type="text" name="firstName" id="firstName" required><br>
  <label for="lastName">Ваша фамилия:</label>
  <input type="text" name="lastName" id="lastName" required><br>
  <label for="password">Ваш пароль:</label>
  <input type="password" name="password" id="password" required><br>

  <input type="submit" value="Войти">

</form>
</body>
</html>
