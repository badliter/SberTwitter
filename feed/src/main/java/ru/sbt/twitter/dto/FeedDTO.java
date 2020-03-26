package ru.sbt.twitter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import ru.sbt.twitter.entity.Tweet;
import ru.sbt.twitter.entity.User;

import java.sql.Timestamp;

@AllArgsConstructor
@Data
@Getter
public class FeedDTO {
    public FeedDTO(Tweet tweet, User user) {
        this.authorName = user.getFirstname();
        this.authorSurname = user.getLastname();
        this.userid = user.getUserid();
        this.tweetid = tweet.getTweetid();
        this.content = tweet.getContent();
        this.date = tweet.getDate();
    }

    private String authorName;
    private String authorSurname;
    private Long userid;
    private Long tweetid;
    private String content;
    private Timestamp date;
}
