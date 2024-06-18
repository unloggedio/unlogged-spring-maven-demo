package org.unlogged.demo;

import io.unlogged.Unlogged;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "org.unlogged.demo")
@EnableTransactionManagement
//@EnableScheduling
public class UnloggedDemoApplication {
    @Unlogged(port = 12100)
    public static void main(String[] args) {
        SpringApplication.run(UnloggedDemoApplication.class, args);
    }
}
