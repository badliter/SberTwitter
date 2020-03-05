package ru.sbt.twitter.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@IdClass(FeedCompositeKey.class)
@Table(name = "FEED")
public class FeedEntity {
    @Id
    @Column(name = "owner_id")
    private Long owner_id;

    @Id
    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "twitt_id")
    @Id
    private Long twitt_id;

    @Column(name = "content")
    private String content;

    @Column(name = "date")
    private Timestamp date;
}
