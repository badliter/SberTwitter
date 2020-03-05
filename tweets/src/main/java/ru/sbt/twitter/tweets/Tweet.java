package ru.sbt.twitter.tweets;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class Tweet {
    private final int id;
    private final LocalDateTime creationTime;
    private final String author;
    private final String content;
}
