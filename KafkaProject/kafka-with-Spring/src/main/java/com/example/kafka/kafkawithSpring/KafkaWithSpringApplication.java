package com.example.kafka.kafkawithSpring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaWithSpringApplication {

	public static void main(String[] args) {

		SpringApplication.run(KafkaWithSpringApplication.class, args);
	}

	//Going to send the message to the kafka Topic not using the Rest Api.
//	@Bean
//	CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate) {
//		return args -> {
//			for (int i=1;i<=10;i++) {
//				kafkaTemplate.send("kafkaDemo", "Message index : " + i + " Hello From Producer");
//			}
//		};
//	}
}
