package ru.sbt.twitter.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.sbt.twitter.Twitt;
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
    private final RestTemplate template;
    private final FeedService feedService;


    /**
     * Получение всей ленты для пользователя
     *
     * @param user_id - id пользователя
     * @param period  - период за который хотим получить ленту
     * @param sorted  - сортировка
     * @return
     */
    @GetMapping(value = "/getTwits/{user_id}")
    public @ResponseBody
    ResponseEntity<String> getTimeline(@PathVariable("user_id") Long user_id,
                                       @RequestParam("period") Date period,
                                       @RequestParam("sorted") Boolean sorted) {
        List<FeedTable> news = feedService.getFeed(user_id);
        for (FeedTable entity:news) {
            System.out.println(entity);
        }
        return new ResponseEntity<>("GET Response : "
                + user_id + ", " + period + ", " + sorted, OK);
    }


    private Twitt twitt(int id) {
        return template.getForObject("http://twitts/" + id, Twitt.class);
    }
    @PostMapping("/addSubscriber/{ownerid}")
    public void getTwitts(@PathVariable("ownerid") Long ownerid,
                          @RequestParam("userid") Long userid) {
        OwnerSubscriptions subs = new OwnerSubscriptions(ownerid, userid);
        feedService.addSubscriber(subs);
    }
    @PostMapping("/addTweet")
    public void getTwitts(@RequestParam("userid") Long userid,@RequestParam("tweetid") Long tweetid,
                            @RequestParam("content") String content, @RequestParam("date") Timestamp date) {


}
