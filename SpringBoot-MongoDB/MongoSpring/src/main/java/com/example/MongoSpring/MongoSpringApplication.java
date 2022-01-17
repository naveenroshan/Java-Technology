package com.example.MongoSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.example.repository")
public class MongoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoSpringApplication.class, args);
	}

}
