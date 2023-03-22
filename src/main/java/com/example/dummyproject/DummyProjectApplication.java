package com.example.dummyproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableMongoRepositories
public class DummyProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DummyProjectApplication.class, args);
	}

}
