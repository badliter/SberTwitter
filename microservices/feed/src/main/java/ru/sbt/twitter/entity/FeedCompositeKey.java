package ru.sbt.twitter.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class FeedCompositeKey implements Serializable {
    private Long owner_id;
    private Long user_id;
    private Long twitt_id;
}
