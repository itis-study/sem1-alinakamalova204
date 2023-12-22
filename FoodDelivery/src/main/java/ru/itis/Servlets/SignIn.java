package ru.itis.Servlets;

import ru.itis.DataBase.RepositoryJDBC;
import ru.itis.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/signIn")
public class SignIn extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("signIn.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id_user = Integer.valueOf(req.getParameter("id_user"));
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String password = req.getParameter("password");

        User user = new User(id_user,firstName,lastName,password);

        try {
            RepositoryJDBC repositoryJDBC = new RepositoryJDBC("jdbc:postgresql://localhost:5432/delivery/users", "postgres", "08210122");
            repositoryJDBC.save(user);
            resp.sendRedirect("http://localhost:8080/FoodDelivery/signUp");
        }catch (Exception e){
            System.out.println(e);
        }

    }

}
