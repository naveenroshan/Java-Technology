package com.example.kafka.kafkawithSpring.Config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    // This class is used to create Topics

    @Bean
    //Since its a class we are using the Bean annotation
    public NewTopic KafkaTopicOne(){
        return TopicBuilder.name("kafkaDemo").build();
    }
}
