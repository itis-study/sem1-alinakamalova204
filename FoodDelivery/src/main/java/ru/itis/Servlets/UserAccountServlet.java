package ru.itis.Servlets;

import ru.itis.DataBase.UserRepositoryJDBC;
import ru.itis.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/account")
public class UserAccountServlet extends HttpServlet {
    UserRepositoryJDBC userRepositoryJDBC = new UserRepositoryJDBC("jdbc:postgresql://localhost:5432/postgres", "postgres","08210122");

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (userRepositoryJDBC.findPersonByLastName((String) request.getAttribute("firstname"), (String) request.getAttribute("lastname")) != null) {
            User user = userRepositoryJDBC.findPersonByLastName((String) request.getAttribute("firstname"), (String) request.getAttribute("lastname"));
            request.setAttribute("user1", user);

        }
        request.getRequestDispatcher("/useracc.jsp").forward(request, response);


    }
}
