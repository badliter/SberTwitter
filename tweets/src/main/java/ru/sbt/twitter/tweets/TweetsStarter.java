package ru.sbt.twitter.tweets;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import static org.springframework.boot.SpringApplication.run;

@EnableEurekaClient
@SpringBootApplication
public class TweetsStarter {
    public static void main(String[] args) {
        run(TweetsStarter.class);
    }
}
