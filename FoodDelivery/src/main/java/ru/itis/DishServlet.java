package ru.itis;

import ru.itis.model.Dish;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/dish")
public class DishServlet extends HttpServlet {
    private Dish dish;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Enter doGet");

       // String action = req.getParameter("action");
        req.setAttribute("dish",dish);
        req.getRequestDispatcher("/dish.jsp").forward(req,resp);
    }
}
