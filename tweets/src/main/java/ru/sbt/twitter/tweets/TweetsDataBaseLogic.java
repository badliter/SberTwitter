package ru.sbt.twitter.tweets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TweetsDataBaseLogic {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    List<Tweet> getAllTweets(long userId){
        return jdbcTemplate.query("SELECT * FROM TWEETS WHERE USERID = ?",
                new Object[]{userId},
                new BeanPropertyRowMapper(Tweet.class));
    }

    Tweet getTweet(long userId, long tweetId){
        try {
            return (Tweet) jdbcTemplate.queryForObject("SELECT * FROM TWEETS WHERE USERID = ? AND TWEETID = ?;",
                    new Object[]{userId, tweetId},
                    new BeanPropertyRowMapper(Tweet.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    Tweet getTweetWithMaxId(long userId){
        try {
            return (Tweet) jdbcTemplate.queryForObject("SELECT TOP 1 * FROM TWEETS WHERE USERID = ? ORDER BY TWEETID DESC;",
                    new Object[]{userId},
                    new BeanPropertyRowMapper(Tweet.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
}

    Long getNumberOfTweets(long userId){
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM TWEETS WHERE USERID = ?;",
                new Object[]{userId},
                Long.class);
    }

    public String updateTweetContent(Tweet tweet){
        jdbcTemplate.update("UPDATE TWEETS SET CONTENT = ? WHERE USERID = ? AND TWEETID = ?;",
                tweet.getContent(),
                tweet.getUserid(),
                tweet.getTweetid());
        return "Tweet was edit!!!";
    }

    public String insertTweet(Tweet tweet) {
        jdbcTemplate.update("INSERT INTO TWEETS values (?, ?, ?, ?);",
                tweet.getUserid(),
                getNumberOfTweets(tweet.getUserid()) != 0 ? getTweetWithMaxId(tweet.getUserid()).getTweetid() + 1 : 1,
                tweet.getContent(),
                tweet.getDate());
        return "Tweet was added!!!";
    }

    public String deleteTweet(long userId, long tweetId) {
        jdbcTemplate.update("DELETE FROM TWEETS WHERE USERID = ? AND TWEETID = ?;",
                userId,
                tweetId);
        return "Tweet was deleted!!!";
    }
}