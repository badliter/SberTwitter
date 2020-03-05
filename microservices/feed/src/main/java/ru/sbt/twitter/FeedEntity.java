package ru.sbt.twitter;

import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
@Entity
@Table(name = "FEED")
@Getter
@Setter
public class FeedEntity {
    @Id
    private long owner_id;
    private long user_id;
    private long twitt_id;
    private String content;
    private Timestamp date;
}
