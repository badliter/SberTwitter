package ru.sbt.twitter.service;

import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import ru.sbt.twitter.entity.Tweet;

public class TweetDeserializer extends JsonDeserializer<Tweet> {
}