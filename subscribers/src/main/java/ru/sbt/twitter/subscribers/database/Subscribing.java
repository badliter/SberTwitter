package ru.sbt.twitter.subscribers.database;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Subscribing implements Serializable {
    private Long user_id;
    private Long subscribing_id;
}