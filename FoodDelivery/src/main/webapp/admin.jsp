<%--
  Created by IntelliJ IDEA.
  User: Алина Камалова
  Date: 18.11.2023
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AdminPage</title>
</head>
<body>

<div class="nav-list">
    <h2 class="section-header">Dish:</h2>
    <ul>
        <li><c:url var="updateDish" value="/admin/updateDish"/><a href="${updateDish}" class="nav-button">внести изменение в блюдо</a></li>

    </ul>

</div>

</body>
</html>
