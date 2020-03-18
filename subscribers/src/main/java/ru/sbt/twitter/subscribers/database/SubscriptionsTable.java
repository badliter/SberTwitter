package ru.sbt.twitter.subscribers.database;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@IdClass(CompositeKey.class)
@Table(name="SUBSCRIPTIONS")
public class SubscriptionsTable {
    @Id
    @Column(name = "USER_ID")
    private Long ownerid;

    @Id
    @Column(name = "SUBSCRIPTION_ID")
    private Long userid;
}