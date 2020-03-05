package ru.sbt.subscribers.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataBaseLogic {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List getSubscribing(long user_id){
        return jdbcTemplate.queryForList("SELECT SUBSCRIBING_ID FROM SUBSCRIBING WHERE USER_ID = ?",
                new Object[]{user_id},
                Long.class);
    }

    public List getSubscribers(long user_id){
        return jdbcTemplate.queryForList("SELECT USER_ID AS SUBSCRIBERS_ID FROM SUBSCRIBING WHERE SUBSCRIBING_ID = ?",
                new Object[]{user_id},
                Long.class);
    }

    public String insertSubscribing(SubscribingCompositeKey subscribing) {
        jdbcTemplate.update("INSERT INTO SUBSCRIBING (USER_ID, SUBSCRIBING_ID)  VALUES (?, ?);",
                subscribing.getUser_id(),
                subscribing.getSubscribing_id());
        return "Subscribing was added!!!";
    }

    public String deleteSubscribing(SubscribingCompositeKey subscribing) {
        jdbcTemplate.update("DELETE FROM SUBSCRIBING WHERE USER_ID = ? AND SUBSCRIBING_ID = ?;",
                subscribing.getUser_id(),
                subscribing.getSubscribing_id());
        return "Subscribing was deleted!!!";
    }
}
