package ru.sbt.twitter.feed.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class FeedCompositeKey implements Serializable {
    private Long ownerid;
    private Long userid;
    private Long twittid;
}
