package ru.sbt.subscribers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sbt.subscribers.database.DataBaseLogic;
import ru.sbt.subscribers.database.Subscribing;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class SubscribersController {
    @Autowired
    private DataBaseLogic dao;

    @GetMapping("/getSubscribing/{user_id}")
    public ResponseEntity<List<Long>> getSubscribing(@PathVariable("user_id") long user_id) {
        return new ResponseEntity<>(dao.getSubscribing(user_id), OK);
    }

    @GetMapping("/getSubscribers/{user_id}")
    public ResponseEntity<List<Long>> getSubscribers(@PathVariable("user_id") long user_id) {
        return new ResponseEntity<>(dao.getSubscribers(user_id), OK);
    }

    @PostMapping("/addSubscribing")
    public ResponseEntity<String> addSubscribing(@RequestBody Subscribing subscribing){
        return new ResponseEntity<>(dao.insertSubscribing(subscribing), OK);
    }

    @PostMapping("/deleteSubscribing")
    public ResponseEntity<String> deleteSubscribing(@RequestBody Subscribing subscribing){
        return new ResponseEntity<>(dao.deleteSubscribing(subscribing), OK);
    }
}
