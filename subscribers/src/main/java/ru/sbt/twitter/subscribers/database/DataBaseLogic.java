package ru.sbt.twitter.subscribers.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataBaseLogic {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Long> getSubscriptions(long user_id){
        return jdbcTemplate.queryForList("SELECT SUBSCRIPTION_ID FROM SUBSCRIPTIONS WHERE USER_ID = ?",
                new Object[]{user_id},
                Long.class);
    }

    public List<Long> getSubscribers(long user_id){
        return jdbcTemplate.queryForList("SELECT USER_ID AS SUBSCRIBERS_ID FROM SUBSCRIPTIONS WHERE SUBSCRIPTION_ID = ?",
                new Object[]{user_id},
                Long.class);
    }

    public String insertSubscription(SubscriptionsTable subscription) {
        jdbcTemplate.update("INSERT INTO SUBSCRIPTIONS (USER_ID, SUBSCRIPTION_ID)  VALUES (?, ?);",
                subscription.getOwnerid(),
                subscription.getUserid());
        return "Subscription was added!!!";
    }

    public String deleteSubscription(SubscriptionsTable subscription) {
        jdbcTemplate.update("DELETE FROM SUBSCRIPTIONS WHERE USER_ID = ? AND SUBSCRIPTION_ID = ?;",
                subscription.getOwnerid(),
                subscription.getUserid());
        return "Subscription was deleted!!!";
    }
}
