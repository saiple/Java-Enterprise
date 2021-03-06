package app;

import lombok.SneakyThrows;
import models.Message;
import models.User;
import repositories.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

/**
 * 03.09.2018
 * UsersRepositoryDemo
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class UsersRepositoryDemo {

    // данные для подключения
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "r1a2z3i4l5";
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";

    @SneakyThrows
    public static void main(String[] args) throws SQLException {
        Connection connection =
                DriverManager.getConnection(URL, USERNAME, PASSWORD);
        UserRepository userRepository = new UserRepositoryConnectionImpl(connection);
      // Optional<User> user = userRepository.read(1L);
        User user = User.builder()
                .firstName("арбуз")
                .lastName("арбузович")
                .username("AR_abuzzze")
                .hashPassword("6767")
                .build();
        userRepository.create(user);
       // System.out.println(user);
        //userRepository.delete(1L);
        System.out.println("все нормас");
//        System.out.println(user);
//
//        MessageRepository messageRepository = new MessageRepositoryConnectionImpl(connection);
//
//        System.out.println(((MessageRepositoryConnectionImpl) messageRepository).chatId(5L, 6L));
//        LikeRepository likeRepository = new LikeRepositoryConnectionImpl(connection);
//        likeRepository.like(3L, 4L);


    }
}
