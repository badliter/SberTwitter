package ru.sbt.twitter.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@IdClass(FeedCompositeKey.class)
@Table(name = "feed")
@Data
public class FeedTable {
    @Id
    @Column(name = "owner_id")
    private Long owner_id;

    @Id
    @Column(name = "user_id")
    private Long user_id;

    @Id
    @Column(name = "twitt_id")
    private Long twitt_id;

    @Column(name = "content")
    private String content;

    @Column(name = "date")
    private Timestamp date;
}
