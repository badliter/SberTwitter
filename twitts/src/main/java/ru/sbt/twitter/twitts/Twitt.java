package ru.sbt.twitter.twitts;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class Twitt {
    private final int id;
    private final LocalDateTime creationTime;
    private final String author;
    private final String content;
}
