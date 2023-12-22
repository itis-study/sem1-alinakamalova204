package ru.itis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Integer id_user;
    private String firstName;
    private String lastName;
    private String password;

    public Order getOrders(){
        User user = new User();
        Dish dish = new Dish();
        Order order = new Order(user.getId_user(), dish.getId_dish());
        return order;
    }

}
