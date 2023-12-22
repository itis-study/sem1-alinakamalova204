package ru.itis.Servlets;

import ru.itis.DataBase.DishRepositoryJDBC;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
@WebServlet("/updateDish")
public class AdminUpdateDish extends HttpServlet {
    private final DishRepositoryJDBC dishRepositoryJDBC;
    private final String HOST = "jdbc:postgresql://localhost:5432/postgres";
    private final String USER = "postgres";
    private final String PASS = "password";

    public AdminUpdateDish(DishRepositoryJDBC dishRepositoryJDBC) {
        this.dishRepositoryJDBC = dishRepositoryJDBC;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
