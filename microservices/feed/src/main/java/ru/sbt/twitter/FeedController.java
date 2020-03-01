package ru.sbt.twitter;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FeedController {
    private final RestTemplate template;

    @GetMapping("/feed")
    public List<Twitt> getFeed() {
        return Arrays.asList(
                twitt(1),
                twitt(2)
        );
    }

    private Twitt twitt(int id) {
            return template.getForObject("http://twitts/" + id, Twitt.class);
    }
}
