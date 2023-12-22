package ru.itis.Servlets;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import ru.itis.model.User;

@WebServlet("/signUp")
public class SignUp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("signUp.jsp").forward(req,resp);
    }
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String firstName = req.getParameter("firstName");
//        String lastName = req.getParameter("lastName");
//        String password = req.getParameter("password");
//
//        // Проверка корректности введенных данных
//        if (isValidCredentials(firstName, lastName, password)) {
//            // Пользователь ввел корректные данные, выполняем вход в аккаунт
//            User user = getUserFromDatabase(firstName, lastName);
//            if (user != null && password.equals(user.getPassword())) {
//                // Вход выполнен успешно, перенаправляем на страницу аккаунта
//                resp.sendRedirect("/account");
//            } else {
//                // Неправильный пароль или пользователь не найден
//                resp.sendRedirect("/signIn?error=invalidCredentials");
//            }
//        } else {
//            // Некорректные данные
//            resp.sendRedirect("/signIn?error=invalidData");
//        }
//    }

    private boolean isValidCredentials(String firstName, String lastName, String password) {
        // Реализуйте свою логику проверки введенных данных, например, проверку на пустые значения и длину пароля
        return !firstName.isEmpty() && !lastName.isEmpty() && !password.isEmpty();
    }

//    private User getUserFromDatabase(String firstName, String lastName) {
//        // Реализуйте получение пользователя из базы данных по его имени и фамилии
//        // Возвращайте объект User или null, если пользователь не найден
//        // Пример:
//        RepositoryJDBC repositoryJDBC = new RepositoryJDBC("jdbc:postgresql://localhost:5432/delivery","postgres","08210122");
//        return repositoryJDBC.getUserByFirstNameAndLastName(firstName, lastName);
//    }
}
