package ru.itis.DataBase;

import ru.itis.model.User;

import java.sql.*;

public class UserRepositoryJDBC {
    public final static String SQL_SAVE = "INSERT INTO users (firstname, lastname, password) VALUES (?, ?, ?)";
    public final static String SQL_GET_BY_ID = "SELECT * FROM users WHERE id = ?";
    private final static String SQL_GET_ALL = "SELECT * FROM users";
    private final static String SQL_DELETE_BY_ID = "DELETE FROM users WHERE id = ?";
    private final static String SQL_FOR_AUTH = "SELECT * FROM users WHERE firstname = ? AND password = ?";
    //private final static String SQL_FOR_EMAIL = "SELECT * FROM teacher WHERE mail = ?";


    private final String HOST;
    private final String USER;
    private final String PASS;

    public UserRepositoryJDBC(String HOST, String USER, String PASS) {
        this.HOST = HOST;
        this.USER = USER;
        this.PASS = PASS;
    }
    public void save(User entity) {
        try (Connection connection = DriverManager.getConnection(HOST, USER, PASS);
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SAVE)) {
            preparedStatement.setString(1, entity.getFirstname());
            preparedStatement.setString(2, entity.getLastname());
            preparedStatement.setString(3, entity.getPassword());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public User findPersonByLastName(String firstname, String lastname) {
        try {
            Connection connection = DriverManager.getConnection(HOST, USER, PASS);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE firstname = ? and lastname = ?");
            preparedStatement.setString(1, firstname);
            preparedStatement.setString(2, lastname);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                User user = new User();
                user.setId_user(Integer.valueOf("id"));
                user.setFirstname("name");
                user.setLastname("surname");
                user.setPassword("password");
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
