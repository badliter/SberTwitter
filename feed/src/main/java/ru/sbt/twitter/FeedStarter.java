package ru.sbt.twitter;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import static org.springframework.boot.SpringApplication.run;

@EnableEurekaClient
@SpringBootApplication
public class FeedStarter {
    public static void main(String[] args) {
        run(FeedStarter.class);
    }
}
