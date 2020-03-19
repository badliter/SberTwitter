package ru.sbt.twitter.subscribers.database;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class CompositeKey implements Serializable {
    private Long ownerid;
    private Long userid;
}