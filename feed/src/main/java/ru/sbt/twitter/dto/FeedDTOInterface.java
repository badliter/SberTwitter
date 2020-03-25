package ru.sbt.twitter.dto;

import java.sql.Timestamp;

public interface FeedDTOInterface {
    Long getOwnerid();

    Long getUserid();

    Long getTweetid();

    String getContent();

    Timestamp getDate();

    String getLogin();

    String getFirstname();

    String getLastname();
}
