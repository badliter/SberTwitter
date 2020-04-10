package ru.sbt.twitter.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.sbt.twitter.registration.model.Status;
import ru.sbt.twitter.registration.model.User;

import java.util.List;

@Repository
public class RegistrationDBLogic {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    User getUserById(long user_id) {
        return (User) jdbcTemplate.queryForObject("SELECT * FROM USERS WHERE userId = ?",
                new Object[]{user_id},
                new BeanPropertyRowMapper(User.class));
    }

    User signUp(User user) {
        jdbcTemplate.update("INSERT INTO USERS (userId, userName, email, password, firstName, lastName, status) values (?, ?, ?, ?, ?, ?, ?);",
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName(),
                "ACTIVE");
        return user;

    }

    User signIn(String username, String password) {
        try {
            User user = (User) jdbcTemplate.queryForObject("SELECT * FROM USERS WHERE userName = ? AND password = ?",
                    new Object[]{username, password},
                    new BeanPropertyRowMapper<>(User.class));
            jdbcTemplate.update("UPDATE USERS SET status = ? WHERE userName = ?",
                    "ACTIVE",
                    user.getUsername());
            return user;
        } catch (Exception e) {
            System.out.println("Wrong username or password!");
        }
        return null;
    }

    User signOut(String username, String password) {
        try {
            User user = (User) jdbcTemplate.queryForObject("SELECT * FROM USERS WHERE userName = ? AND password = ?",
                    new Object[]{username, password},
                    new BeanPropertyRowMapper<>(User.class));
            jdbcTemplate.update("UPDATE USERS SET status = ? WHERE userName = ?",
                    "NOT_ACTIVE",
                    user.getUsername());
            return user;
        } catch (Exception e) {
            System.out.println("There is no such a user");
        }
        return null;
    }

}
