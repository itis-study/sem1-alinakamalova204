package ru.itis;
import ru.itis.model.DishItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@WebServlet("/shop")
public class ShoppingCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Магазин</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Товары</h1>");
        out.println("<ul>");
        out.println("<li data-id=\"1\">Товар 1<button onclick=\"addToCart(1)\">Купить</button></li>");
        out.println("<li data-id=\"2\">Товар 2<button onclick=\"addToCart(2)\">Купить</button></li>");
        out.println("<li data-id=\"3\">Товар 3<button onclick=\"addToCart(3)\">Купить</button></li>");
        out.println("</ul>");
        out.println("<h2>Корзина</h2>");
        out.println("<ul id=\"cart\"></ul>");
        out.println("<script>");
        out.println("function addToCart(productId) {");
        out.println("var cart = document.getElementById(\"cart\");");
        out.println("var product = document.querySelector('[data-id=\"' + productId + '\"]');");
        out.println("var productName = product.textContent.trim();");
        out.println("var li = document.createElement(\"li\");");
        out.println("li.textContent = productName;");
        out.println("cart.appendChild(li);");
        out.println("}");
        out.println("</script>");
        out.println("</body>");
        out.println("</html>");
    }

    private List<DishItem> items = new ArrayList<>();
    private BigDecimal totalPrice;

    //сохранение в корзине
    public void save(DishItem newItem){
        for (DishItem item : items){
            if (item.getId().equals(newItem.getId())){
                item.setNum(item.getNum() + newItem.getNum());
                return;
            }
        }
        items.add(newItem);
    }

    // Удаляем товар с указанным id из корзины покупок
    public void delete(String id){
        Iterator<DishItem> dish = items.iterator();
        while (dish.hasNext()){
            DishItem item = dish.next();
            if (item.getId().equals(id)){
                items.remove(item);
                break;
            }
        }
    }
    // Все товары в корзине
    public List<DishItem> getItems(){
        return items;
    }
    // Общая стоимость корзины покупок
    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (DishItem item : items){
            totalPrice = totalPrice.add(item.getPrice().multiply(new BigDecimal(item.getNum())));
        }
        return totalPrice;
    }
}
