package ru.sbt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RegistrationDataBaseLogic {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    List getAllUsers(long user_id){
        return jdbcTemplate.query("SELECT * FROM REGISTRATION WHERE USER_ID = ?",
                new Object[]{user_id},
                new BeanPropertyRowMapper(User.class));
    }
}

