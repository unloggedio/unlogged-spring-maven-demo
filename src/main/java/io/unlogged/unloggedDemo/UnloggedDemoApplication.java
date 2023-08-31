package io.unlogged.unloggedDemo;

import io.unlogged.Unlogged;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UnloggedDemoApplication {

	@Unlogged
	public static void main(String[] args) {
		SpringApplication.run(UnloggedDemoApplication.class, args);
	}

}
