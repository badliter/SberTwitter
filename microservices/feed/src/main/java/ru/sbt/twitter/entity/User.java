package ru.sbt.twitter.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usersinfo", schema = "feed_cfg")
@Data
public class User {
    @Id
    @Column(name = "userid")
    private Long userid;

    @Column(name = "login")
    private String login;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;
}
