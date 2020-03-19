package ru.sbt.twitter.subscribers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sbt.twitter.subscribers.database.DataBaseLogic;
import ru.sbt.twitter.subscribers.database.SubscriptionsTable;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class SubscribersController {
    @Autowired
    private DataBaseLogic dao;

    @GetMapping("/getsubscriptions/{user_id}")
    public ResponseEntity<List<Long>> getSubscriptions(@PathVariable("user_id") long userId) {
        return new ResponseEntity<>(dao.getSubscriptions(userId), OK);
    }

    @GetMapping("/getsubscribers/{user_id}")
    public ResponseEntity<List<Long>> getSubscribers(@PathVariable("user_id") long userId) {
        return new ResponseEntity<>(dao.getSubscribers(userId), OK);
    }

    @PostMapping("/addsubscription")
    public ResponseEntity<String> addSubscription(@RequestBody SubscriptionsTable subscription){
        return new ResponseEntity<>(dao.insertSubscription(subscription), OK);
    }

    @PostMapping("/deletesubscription")
    public ResponseEntity<String> deleteSubscription(@RequestBody SubscriptionsTable subscription){
        return new ResponseEntity<>(dao.deleteSubscription(subscription), OK);
    }
}
