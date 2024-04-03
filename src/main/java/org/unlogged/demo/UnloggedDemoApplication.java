package org.unlogged.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class UnloggedDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(UnloggedDemoApplication.class, args);
    }
}
