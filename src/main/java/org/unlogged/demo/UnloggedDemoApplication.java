package org.unlogged.demo;

//import io.unlogged.Unlogged;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class UnloggedDemoApplication {
//    @Unlogged
    public static void main(String[] args) {
        SpringApplication.run(UnloggedDemoApplication.class, args);
    }

}
