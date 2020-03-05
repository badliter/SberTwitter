package ru.sbt.twitter.feed;

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
    public List<Tweet> getFeed() {
        return Arrays.asList(
                tweet(1),
                tweet(2)
        );
    }

    private Tweet tweet(int id) {
            return template.getForObject("http://tweets/" + id, Tweet.class);
    }
}
