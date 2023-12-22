package ru.itis.DataBase;

import ru.itis.model.Dish;
import ru.itis.model.Order;
import ru.itis.model.User;

import java.util.List;

public class Database {
    private List<User> users;
    private List<Dish> dishes;
    private List<Order> orders;

    public void addUser(User user) {
        users.add(user);
    }

    public void addDish(Dish dish) {
        dishes.add(dish);
    }
    public void addOrder(Order order){
        orders.add(order);
    }

}
