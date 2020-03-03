package ru.sbt.twitts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcTemplateTwittsDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    List getAllTwitts(long user_id){
        return jdbcTemplate.query("SELECT * FROM TWITTS WHERE USER_ID = ?",
                new Object[]{user_id},
                new BeanPropertyRowMapper(Twitt.class));
    }

    Twitt getTwitt(long user_id, long twitt_id){
        return (Twitt) jdbcTemplate.queryForObject("SELECT * FROM TWITTS WHERE USER_ID = ? AND TWITT_ID = ?;",
                new Object[]{user_id, twitt_id},
                new BeanPropertyRowMapper(Twitt.class));
    }

    Twitt getTwittWithMaxId(long user_id){
        return (Twitt) jdbcTemplate.queryForObject("SELECT TOP 1 * FROM TWITTS WHERE USER_ID = ? ORDER BY TWITT_ID DESC;",
                new Object[]{user_id},
                new BeanPropertyRowMapper(Twitt.class));
    }

    Long getNumberOfTwitts(long user_id){
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM TWITTS WHERE USER_ID = ?;",
                new Object[]{user_id},
                Long.class);
    }

    public void updateTwittContent(Twitt twitt){
        jdbcTemplate.update("UPDATE TWITTS SET CONTENT = ? WHERE USER_ID = ? AND TWITT_ID = ?;",
                twitt.getContent(),
                twitt.getUser_id(),
                twitt.getTwitt_id());
    }

    public void insertTwitt(Twitt twitt) {
        jdbcTemplate.update("INSERT INTO TWITTS values (?, ?, ?, ?);",
                twitt.getUser_id(),
                twitt.getTwitt_id(),
                twitt.getContent(),
                twitt.getCreation_time());
    }

    public void deleteTwitt(long user_id, long twitt_id) {
        jdbcTemplate.update("DELETE FROM TWITTS WHERE USER_ID = ? AND TWITT_ID = ?;",
                user_id,
                twitt_id);
    }
}