package ru.sbt.twitter.twitts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
public class TwittsController {
    @Autowired
    private TwittsDataBaseLogic dao;

    @GetMapping("/getAllTwitts/{user_id}")
    public ResponseEntity<List<Twitt>> getAllTwits(@PathVariable("user_id") long user_id) {
        return new ResponseEntity<>(dao.getAllTwitts(user_id), OK);
    }

    @GetMapping("getTwitt/{user_id}/{twitt_id}")
    public ResponseEntity<Twitt> getTwitt(@PathVariable("user_id") long user_id, @PathVariable("twitt_id") long twitt_id){
        return new ResponseEntity<>(dao.getTwitt(user_id, twitt_id), OK);
    }

    @GetMapping("getLastTwittId/{user_id}")
    public ResponseEntity<Long> getLastTwittId(@PathVariable("user_id") long user_id){
        return new ResponseEntity<>(dao.getTwittWithMaxId(user_id).getTwitt_id(), OK);
    }

    @GetMapping("getNumberOfTwitts/{user_id}")
    public ResponseEntity<Long> getNumberOfTwitts(@PathVariable("user_id") long user_id){
        return new ResponseEntity<>(dao.getNumberOfTwitts(user_id), OK);
    }

    @PostMapping("/editTwitt")
    public ResponseEntity<String> editTwitt(@RequestBody Twitt twitt){
        return new ResponseEntity<>(dao.updateTwittContent(twitt), OK);
    }

    @PostMapping("/postTwitt")
    public ResponseEntity<String> postTwitt(@RequestBody Twitt twitt){
        return new ResponseEntity<>(dao.insertTwitt(twitt), OK);
    }

    @PostMapping("/deleteTwitt")
    public ResponseEntity<String> deleteTwitt(@RequestBody Twitt twitt){
        return new ResponseEntity<>(dao.deleteTwitt(twitt.getUser_id(), twitt.getTwitt_id()), OK);
    }
}
