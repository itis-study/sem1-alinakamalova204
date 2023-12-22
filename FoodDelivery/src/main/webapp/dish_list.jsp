<%@ page import="ru.itis.model.User" %>
<%@ page import="ru.itis.model.Order" %><%--
  Created by IntelliJ IDEA.
  User: Алина Камалова
  Date: 08.11.2023
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html style="background-color: #fdf8f4">
<head>
    <title>Корзина товаров</title>
</head>
<body>

<div class="tel">

  <%
    User user = new User();

    if (user == null) {
  %>
  <button onclick="redirectToSignUp()">Войти</button>
  <button onclick="redirectToSignIn()">Зарегистрироваться</button>
  <% } else { %>
  <div>Привет, <%= user.getFirstName() %>!</div>
  <button onclick="redirectToYourShopBag()">Корзина (<%= user.getOrders().size() %>)</button>
  <% } %>
</div>
</body>
</html>
