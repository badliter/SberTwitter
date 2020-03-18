package ru.sbt.twitter.tweets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
public class TweetsController {
    @Autowired
    private TweetsDataBaseLogic dao;

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
