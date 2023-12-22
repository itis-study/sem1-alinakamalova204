package ru.itis.DataBase;

import ru.itis.model.Dish;
import ru.itis.model.Order;
import ru.itis.model.User;

import java.sql.*;
import java.util.Optional;

public class RepositoryJDBC {
    private final String HOST;
    private final String USER;
    private final String PASS;
    public RepositoryJDBC(String HOST, String USER, String PASS) {
        this.HOST = HOST;
        this.USER = USER;
        this.PASS = PASS;
    }
    public void save(User entity) {
        try (Connection connection = DriverManager.getConnection(HOST, USER, PASS);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (firstName,lastName,password) VALUES (?,?,?)")) {
            preparedStatement.setString(1, entity.getFirstName());
            preparedStatement.setString(2, entity.getLastName());
            preparedStatement.setString(3, entity.getPassword());

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0){
                System.out.println("Данные успешно сохранены в базу данных.");
            }

        } catch (SQLException e) {
            System.out.println("Ошибка при сохранении данных в базу данных: " + e.getMessage());
        }
    }
    public void save(Order entity) {
        try (Connection connection = DriverManager.getConnection(HOST, USER, PASS);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO oreders (id_user, id_dish) VALUES (?,?)")) {
            preparedStatement.setString(1, String.valueOf(entity.getId_user()));
            preparedStatement.setString(2, String.valueOf(entity.getId_dish()));


            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0){
                System.out.println("Данные успешно сохранены в базу данных.");
            }

        } catch (SQLException e) {
            System.out.println("Ошибка при сохранении данных в базу данных: " + e.getMessage());
        }
    }


    public Optional<Dish> findById(String id_dish) {
        try (Connection connection = DriverManager.getConnection(HOST, USER, PASS);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM dish WHERE id_dish = ?")) {
            preparedStatement.setString(1, id_dish);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Dish dish = new Dish();
                    dish.setId_dish(resultSet.getInt(id_dish));
                    dish.setName(resultSet.getString("name"));
                    dish.setName(String.valueOf(resultSet.getInt("price")));
                    return Optional.of(dish);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
