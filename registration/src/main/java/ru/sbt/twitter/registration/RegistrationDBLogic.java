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
        return (User) jdbcTemplate.queryForObject("SELECT * FROM USERS WHERE ID = ?",
                new Object[]{user_id},
                new BeanPropertyRowMapper(User.class));
    }

    String signUp(User user) {
        jdbcTemplate.update("INSERT INTO USERS (ID, USERNAME, EMAIL, PASSWORD, FIRST_NAME, LAST_NAME, STATUS) values (?, ?, ?, ?, ?, ?, ?);",
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName(),
                "ACTIVE");
        return "You were successfully signed up";

    }

    User signIn(String username, String password) {
        try {
            User user = (User) jdbcTemplate.queryForObject("SELECT * FROM USERS WHERE USERNAME = ? AND PASSWORD = ?",
                    new Object[]{username, password},
                    new BeanPropertyRowMapper<>(User.class));
            jdbcTemplate.update("UPDATE USERS SET STATUS = ? WHERE USERNAME = ? AND ID = ?",
                    "ACTIVE",
                    user.getUsername(),
                    user.getId());
            return user;
        } catch (Exception e) {
            System.out.println("Wrong username or password!");
        }
        return null;
    }

    String signOut(String username) {
        try {
            jdbcTemplate.update("UPDATE USERS SET STATUS = ? WHERE USERNAME = ?",
                    "NOT_ACTIVE",
                    username);
            return "You successfully signed out," + " " + username;
        } catch (Exception e) {
            System.out.println("There is no such a user");
        }
        return null;
    }

}
