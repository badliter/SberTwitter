package ru.sbt.twitter.comments;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@Table
public class Comment {
    @PrimaryKey("id") private UUID id;
    @Column("tweet_id") private Integer tweetId;
    @Column("timestamp") private Date timestamp;
    @Column("author") private String author;
    @Column("content")private String content;
}
