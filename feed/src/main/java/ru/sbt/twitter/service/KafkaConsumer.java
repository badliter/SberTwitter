package ru.sbt.twitter.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import ru.sbt.twitter.entity.Tweet;

import java.util.List;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "Kafka_Example", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }


    @KafkaListener(topics = "Feed", groupId = "group_json")
    public void consumeJson(@Payload List<Tweet> user) {
        System.out.println("Consumed JSON Message: " + user);
    }
}
