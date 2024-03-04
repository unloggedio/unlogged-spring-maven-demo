package org.unlogged.demo;

import io.unlogged.Unlogged;
import io.unlogged.UnloggedMethod;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class UnloggedDemoApplication {
    @Unlogged (counter = "2")
    public static void main(String[] args) {
        SpringApplication.run(UnloggedDemoApplication.class, args);
    }

}
