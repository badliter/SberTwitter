package ru.sbt.twitter.subscribers;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import static org.springframework.boot.SpringApplication.run;

@EnableEurekaClient
@SpringBootApplication
public class SubscribersStarter {
    public static void main(String[] args) {
        run(SubscribersStarter.class);
    }
}
