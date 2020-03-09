package ru.sbt.twitter;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import static org.springframework.boot.SpringApplication.run;

@EnableEurekaServer
@SpringBootApplication
public class EurekaStarter {
    public static void main(String[] args) {
        run(EurekaStarter.class);
    }
}
