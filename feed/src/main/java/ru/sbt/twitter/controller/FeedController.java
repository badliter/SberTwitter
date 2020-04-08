package ru.sbt.twitter.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.client.RestTemplate;
import ru.sbt.twitter.dto.FeedDTO;
import ru.sbt.twitter.dto.FeedDTOInterface;
import ru.sbt.twitter.entity.OwnerSubscriptions;
import ru.sbt.twitter.entity.Tweet;
import ru.sbt.twitter.entity.User;
import ru.sbt.twitter.service.FeedService;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
public class FeedController {
    private final FeedService feedService;

    @GetMapping("/getUser/{userid}")
    public ResponseEntity<User> getUserFromReg(@PathVariable("userid") Long userid) throws JsonProcessingException {
        User user = feedService.getUserFromReg(userid);
        return new ResponseEntity<>(user, OK);
    }

    @GetMapping("/feed/{ownerid}")
    public ResponseEntity<List<FeedDTOInterface>> getFeed(@PathVariable("ownerid") Long ownerid) {
        List<FeedDTOInterface> feed = feedService.getFeed(ownerid);
        return new ResponseEntity<>(feed, OK);
    }

    @GetMapping("/tweets/{userid}")
    public ResponseEntity<Set<Tweet>> getTweets(@PathVariable("userid") Long userid) {
        Set<Tweet> tweets = feedService.getTweets(userid);
        return new ResponseEntity<>(tweets, OK);
    }

    @GetMapping("/userinfo/{userid}")
    public ResponseEntity<User> getUser(@PathVariable("userid") Long userid) {
        User user = feedService.getUserInfoById(userid);
        return new ResponseEntity<>(user, OK);
    }

    @GetMapping("/onlineFeed/{userid}")
    public ResponseEntity<?> getOnlineFeed(@PathVariable("userid") Long userid) throws JsonProcessingException {
        List<FeedDTO> feed = feedService.getFeedOnline(userid);
        return new ResponseEntity<>(feed, OK);
    }

    @PostMapping("/addSubscriber/{ownerid}")
    public void getTwitts(@PathVariable("ownerid") Long ownerid,
                          @RequestParam("userid") Long userid) {
        OwnerSubscriptions subs = new OwnerSubscriptions(ownerid, userid);
        feedService.addSubscriber(subs);
    }

    @PostMapping("/addTweet")
    public void getTwitts(@RequestParam("userid") Long userid, @RequestParam("tweetid") Long tweetid,
                          @RequestParam("content") String content, @RequestParam("date") Timestamp date) {

        Tweet tweet = new Tweet(userid, tweetid, content, date);
        feedService.addTweet(tweet);
    }

    @PostMapping("/addUser")
    public void getTwitts(@RequestParam("userid") Long userid, @RequestParam("login") String login,
                          @RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname) {

        User user = new User(userid, login, firstname, lastname);
        feedService.addUser(user);
    }
}
