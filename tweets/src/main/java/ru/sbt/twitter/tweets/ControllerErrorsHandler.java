package ru.sbt.twitter.tweets;

import org.springframework.http.ResponseEntity;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class ControllerErrorsHandler {

    public static ResponseEntity badRequest(long userId){
        return new ResponseEntity<>("400: Bad Request - No Tweets for user_id = " +  userId, BAD_REQUEST);
    }

    public static ResponseEntity badRequest(long userId, long tweetId){
        return new ResponseEntity<>("400: Bad Request - No Tweet tweet_id  = " + tweetId + " for user_id = " +  userId, BAD_REQUEST);
    }
}
