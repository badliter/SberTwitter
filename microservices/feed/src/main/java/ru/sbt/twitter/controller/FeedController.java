package ru.sbt.twitter.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.sbt.twitter.entity.FeedTable;
import ru.sbt.twitter.service.FeedService;
import ru.sbt.twitter.Twitt;

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
     * TODO
     * @return
     */
    @GetMapping("/feed/{userid}")
    public List<FeedTable> getFeed(@PathVariable("userid") Long userid) {
        List<FeedTable> news = feedService.getFeed(userid);
        return news;
    }


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

    /**
     * Обновление ленты пользователя, при добавлении новых твитов
     *
     * @param user_id  - id пользователя
     * @param twit_ids - лист твитов
     * @return
     */
    @PutMapping(value = "/updateTwits/{user_id}")
    public @ResponseBody
    ResponseEntity<String> updateTwitsFromFeedByUserId(@PathVariable("user_id") Long user_id,
                                                       @RequestParam List<Integer> twit_ids) {
        return new ResponseEntity<>("Put Response : "
                + user_id + ", " + twit_ids, OK);
    }

    /**
     * Удаление твитов из ленты пользователя
     *
     * @param user_id  - id пользователя
     * @param twit_ids - лист твитов
     * @return
     */
    @DeleteMapping(value = "/deleteTwits/{user_id}")
    public @ResponseBody
    ResponseEntity<String> deleteTwitsFromFeedByUserId(@PathVariable("user_id") Long user_id,
                                                       @RequestParam List<Integer> twit_ids) {
        return new ResponseEntity<>("Delete Response : "
                + user_id + ", " + twit_ids, OK);
    }

}
