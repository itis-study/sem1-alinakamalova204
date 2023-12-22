package ru.itis.Servlets;

import ru.itis.DataBase.Database;
import ru.itis.DataBase.RepositoryJDBC;
import ru.itis.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/orders")
public class OrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("orders.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id_dish = Integer.valueOf(req.getParameter("id_dish"));
        Integer id_user = Integer.valueOf(req.getParameter("id_dish"));

        Order order = new Order(id_user,id_dish);
        try {
            RepositoryJDBC repositoryJDBC = new RepositoryJDBC("jdbc:postgresql://localhost:5432/delivery/users", "postgres", "08210122");
            repositoryJDBC.save(order);

        }catch (Exception e){
            System.out.println(e);
        }
    }

}
