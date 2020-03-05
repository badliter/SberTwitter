package ru.sbt.twitts;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
public class Twitt {
    private Long user_id;
    private Long twitt_id;
    private String content;
    private OffsetDateTime creation_time;
}
