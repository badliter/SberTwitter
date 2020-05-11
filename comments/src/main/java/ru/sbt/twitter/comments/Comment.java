package ru.sbt.twitter.comments;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;
import java.util.UUID;

@Data
@Table
public class Comment {
    @PrimaryKey("id")
    private final UUID id;

    @Column("tweet_id")
    private final Integer tweetId;

    @Column("timestamp")
    private final Date timestamp;

    @Column("author")
    private final String author;

    @Column("content")
    private final String content;
}
