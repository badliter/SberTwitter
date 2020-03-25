package ru.sbt.twitter.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class OwnerSubscriptionsCompositeKey implements Serializable {
    private Long ownerid;
    private Long userid;
}
