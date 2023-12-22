package ru.itis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    private Integer id_user;
    private Integer id_dish;

    public int size(){
        User user = new User();
        Dish dish = new Dish();
        Order order = new Order(user.getId_user(), dish.getId_dish());
        List<Order> orders = new ArrayList<>();
        orders.add(order);
        return orders.size();
    }
}
