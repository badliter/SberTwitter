package ru.sbt.twitter.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@IdClass(OwnerSubscriptionsCompositeKey.class)
@Table(name = "ownersubscriptions", schema = "feed_cfg")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OwnerSubscriptions {
    @Id
    @Column(name = "ownerid")
    private Long ownerid;
    @Id
    @Column(name = "userid")
    private Long userid;
}
