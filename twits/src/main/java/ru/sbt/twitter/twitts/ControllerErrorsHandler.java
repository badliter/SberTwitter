package ru.sbt.twitts;

import org.springframework.http.ResponseEntity;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class ControllerErrorsHandler {

    public static ResponseEntity badRequest(long user_id){
        return new ResponseEntity<>("400: Bad Request - No Tweets for user_id = " +  user_id, BAD_REQUEST);
    }

    public static ResponseEntity badRequest(long user_id, long tweet_id){
        return new ResponseEntity<>("400: Bad Request - No Tweet tweet_id  = " + tweet_id + " for user_id = " +  user_id, BAD_REQUEST);
    }
}
