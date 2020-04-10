package ru.sbt.twitter.tweets;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("kafka")
public class TweetsController {
    @Value ("${topic.sendTweet}")
    private String TOPIC;
    @Autowired
    private TweetsDataBaseLogic dao;
    @Autowired
    private KafkaTemplate<String, Tweet> kafkaTemplate;
    /////
    @GetMapping("sendtweet/{user_id}/{tweet_id}")
    public ResponseEntity<Tweet> sendTweet(@PathVariable("user_id") long userId, @PathVariable("tweet_id") long tweetId){
        Tweet tweet = dao.getTweet(userId, tweetId);
        kafkaTemplate.send(TOPIC, tweet);
        if (tweet == null)
            return ControllerErrorsHandler.badRequest(userId, tweetId);
        return new ResponseEntity<>(tweet, OK);
    }
    /////

    @GetMapping("/getalltweets/{user_id}")
    public ResponseEntity<List<Tweet>> getAllTweets(@PathVariable("user_id") long userId) {
        return new ResponseEntity<>(dao.getAllTweets(userId), OK);
    }

    @GetMapping("gettweet/{user_id}/{tweet_id}")
    public ResponseEntity<Tweet> getTweet(@PathVariable("user_id") long userId, @PathVariable("tweet_id") long tweetId){
        Tweet tweet = dao.getTweet(userId, tweetId);
        if (tweet == null)
            return ControllerErrorsHandler.badRequest(userId, tweetId);
        return new ResponseEntity<>(tweet, OK);
    }

    @GetMapping("getlasttweetid/{user_id}")
    public ResponseEntity<Long> getLastTweetId(@PathVariable("user_id") long userId) {
        Tweet tweet = dao.getTweetWithMaxId(userId);
        if (tweet == null)
            return ControllerErrorsHandler.badRequest(userId);
        return new ResponseEntity<>(tweet.getTweetid(), OK);
    }

    @GetMapping("getnumberoftweets/{user_id}")
    public ResponseEntity<Long> getNumberOfTweets(@PathVariable("user_id") long userId){
        return new ResponseEntity<>(dao.getNumberOfTweets(userId), OK);
    }

    @PostMapping("/editTweet")
    public ResponseEntity<String> editTweet(@RequestBody Tweet tweet){
        return new ResponseEntity<>(dao.updateTweetContent(tweet), OK);
    }

    @PostMapping("/postTweet")
    public ResponseEntity<String> postTweet(@RequestBody Tweet tweet){
        return new ResponseEntity<>(dao.insertTweet(tweet), OK);
    }

    @PostMapping("/deleteTweet")
    public ResponseEntity<String> deleteTweet(@RequestBody Tweet tweet){
        return new ResponseEntity<>(dao.deleteTweet(tweet.getUserid(), tweet.getTweetid()), OK);
    }
}
