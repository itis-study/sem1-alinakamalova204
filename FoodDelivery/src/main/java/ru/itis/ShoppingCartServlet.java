package ru.itis;

import ru.itis.ShoppingCart;
import ru.itis.model.DishItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
@WebServlet("/shoppingCard")
public class ShoppingCartServlet extends HttpServlet {
    private static final long serialVersionUID = -5568788051811437779L;

    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String cmd = req.getParameter("cmd");
        if ("save".equals(cmd)) {
            this.save(req, resp);
        } else if ("delete".equals(cmd)) {
            this.delete(req, resp);
        }
        resp.sendRedirect("dish_list.jsp");
    }
    protected void save(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 1. Получить параметры запроса
        String name = req.getParameter("name");
        String num = req.getParameter("num");
        String id = "";
        BigDecimal price = BigDecimal.ZERO;
        // Я написал количество и цену за единицу
        if ("iPhone 11".equals(name)) {
            id = "11";
            price = new BigDecimal("5000");
        } else if ("iPhone 11 Pro".equals(name)) {
            id = "22";
            price = new BigDecimal("8000");
        } else if ("iPhone 11 Pro Max".equals(name)) {
            id = "33";
            price = new BigDecimal("11000");
        }
        DishItem item = new DishItem(id, name, price, Integer.valueOf(num));

        // 2. Вызов бизнес-метода
        ShoppingCart cart = (ShoppingCart) req.getSession().getAttribute("SHOPPINGCART_IN_SESSION");
        System.out.println(cart);
        if (cart == null) {
            cart = new ShoppingCart();
            req.getSession().setAttribute("SHOPPINGCART_IN_SESSION", cart);
        }
        cart.save(item);
        System.out.println(cart);

        // 3. Переход через интерфейс управления
    }
    protected void delete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 1. Получить параметры запроса
        String id = req.getParameter("id");
        // 2. Вызов бизнес-метода
        ShoppingCart cart = (ShoppingCart) req.getSession().getAttribute("SHOPPINGCART_IN_SESSION");
        cart.delete(id);
        // 3. Переход через интерфейс управления
    }
}
