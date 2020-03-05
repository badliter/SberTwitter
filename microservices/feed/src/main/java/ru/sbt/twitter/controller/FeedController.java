package ru.sbt.twitter.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.sbt.twitter.Twitt;
import ru.sbt.twitter.dto.FeedDTOInterface;
import ru.sbt.twitter.service.FeedService;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
public class FeedController {
    private final RestTemplate template;
    private final FeedService feedService;


    /**
     *
     *
     * @return
     */
    @GetMapping("/feed/{userid}")
    public @ResponseBody List<FeedDTOInterface> getFeed(@PathVariable("userid") Long userid) {
        List<FeedDTOInterface> news = feedService.getFeed(userid);
        return news;
    }

//    @PostMapping("/addTwitt")
//    public void postTwitt(@RequestBody List<TwittsTable> twittsTables){
//        feedService.addTwitts(twittsTables);
//    }

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
        return new ResponseEntity<>("GET Response : "
                + user_id + ", " + period + ", " + sorted, OK);
    }


    private Twitt twitt(int id) {
        return template.getForObject("http://twitts/" + id, Twitt.class);
    }


}
