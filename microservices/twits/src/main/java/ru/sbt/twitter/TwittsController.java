package ru.sbt.twitter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static java.time.LocalDateTime.now;

@RestController
public class TwittsController {
    @GetMapping("/{id}")
    public Twitt getById(@PathVariable("id") int id) {
        System.out.println(id);
        return new Twitt(id, now(), "Me", "content" + id);
    }
}
