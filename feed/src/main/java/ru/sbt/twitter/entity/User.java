package ru.sbt.twitter.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usersinfo", schema = "feed_cfg")
@Data
//@Value
@JsonIgnoreProperties(ignoreUnknown = true)
//@AllArgsConstructor
public class User {
    @JsonCreator
    public User(@JsonProperty("id") Long userid, @JsonProperty("username") String login,
         @JsonProperty("firstName") String firstname,
         @JsonProperty("lastName") String lastname) {
        this.userid = userid;
        this.login = login;
        this.firstname = firstname;
        this.lastname = lastname;
    }
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
