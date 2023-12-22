<%--
  Created by IntelliJ IDEA.
  User: Алина Камалова
  Date: 21.10.2023
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html style="background-color: #fdf8f4">
<head>
    <title>Dish</title>
</head>
<body>
<section>
    <h3>Dish</h3>
    <jsp:useBean id="dish" scope="request" type="ru.itis.model.Dish"/>
    <tr>
        <td>Name: ${dish.name} | Price: ${dish.price}</td>
        <td><a href="dish?action=update"></a></td>
    </tr>
</section>
</body>
</html>
