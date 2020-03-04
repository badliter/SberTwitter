package ru.sbt.subscribers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sbt.subscribers.database.SubscribingCompositeKey;
import ru.sbt.subscribers.database.DataBaseLogic;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class SubscribersController {
    @Autowired
    private DataBaseLogic dao;

    @GetMapping("/getSubscribing/{user_id}")
    public ResponseEntity<List<SubscribingCompositeKey>> getSubscribing(@PathVariable("user_id") long user_id) {
        return new ResponseEntity<>(dao.getSubscribing(user_id), OK);
    }

    @GetMapping("/getSubscribers/{user_id}")
    public ResponseEntity<List<SubscribingCompositeKey>> getSubscribers(@PathVariable("user_id") long user_id) {
        return new ResponseEntity<>(dao.getSubscribers(user_id), OK);
    }

    @PutMapping("/addSubscribing")
    public ResponseEntity<String> addSubscribing(@RequestBody SubscribingCompositeKey subscribing){
        dao.insertSubscribing(subscribing);
        return new ResponseEntity<>("Subscribing was added!!!", OK);
    }

    @DeleteMapping("/deleteSubscribing")
    public ResponseEntity<String> deleteSubscribing(@RequestBody SubscribingCompositeKey subscribing){
        dao.deleteSubscribing(subscribing);
        return new ResponseEntity<>("Subscribing was deleted!!!", OK);
    }
}
