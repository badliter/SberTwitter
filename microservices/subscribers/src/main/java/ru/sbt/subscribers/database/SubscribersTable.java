package ru.sbt.subscribers.database;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SubscribersTable {
    private Long user_id;
    private Long subscribers_id;
}