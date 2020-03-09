package ru.sbt.twitter.feed.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@IdClass(FeedCompositeKey.class)
@Table(name = "feed", schema = "feed_cfg")
@Data
public class FeedTable {
    @Id
    @Column(name = "ownerid")
    private Long ownerid;

    @Id
    @Column(name = "userid")
    private Long userid;

    @Id
    @Column(name = "twittid")
    private Long twittid;

    @Column(name = "content")
    private String content;

    @Column(name = "date")
    private Timestamp date;
}
