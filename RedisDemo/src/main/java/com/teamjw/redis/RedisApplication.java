package com.teamjw.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedisApplication {

    public static void main(String[] args) {

        //System.out.println("gg" + System.getProperty("server.servlet.context-path"));
        System.out.println("####start####");
        SpringApplication.run(RedisApplication.class, args);
    }

}