package ru.sbt.twitter.dto;

import java.sql.Timestamp;

public interface FeedDTOInterface {
    Long getUserid();
    Long getTweetid();
    String getContent();
    Timestamp getDate();
    String getLogin();
    String getName();
    String getSurname();
}
