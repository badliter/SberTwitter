package ru.sbt.twitter.feed;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Tweet {
    private int id;
    private LocalDateTime creationTime;
    private String author;
    private String content;
}
