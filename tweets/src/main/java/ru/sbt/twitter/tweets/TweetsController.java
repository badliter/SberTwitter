package ru.sbt.twitter.tweets;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static java.time.LocalDateTime.now;

@RestController
public class TweetsController {
    @GetMapping("/{id}")
    public Tweet getById(@PathVariable("id") int id) {
        System.out.println(id);
        return new Tweet(id, now(), "Me", "content" + id);
    }
}
