package ru.sbt.twitter;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Twitt {
    private int id;
    private LocalDateTime creationTime;
    private String author;
    private String content;
}
