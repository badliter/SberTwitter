package ru.sbt.twitter.twitts;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import static org.springframework.boot.SpringApplication.run;

@EnableEurekaClient
@SpringBootApplication
public class TwittsStarter {
    public static void main(String[] args) {
        run(TwittsStarter.class);
    }
}
