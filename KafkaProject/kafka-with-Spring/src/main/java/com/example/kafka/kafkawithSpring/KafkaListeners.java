package com.example.kafka.kafkawithSpring;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "kafkaDemo",groupId = "groupOne")
    void listener(String data){
        System.out.println("Data Consumed = " + data);
    }
}
