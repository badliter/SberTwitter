package ru.sbt.twitter.tweets;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
public class Tweet {
    private Long userid;
    private Long tweetid;
    private String content;
    private OffsetDateTime date;
}

