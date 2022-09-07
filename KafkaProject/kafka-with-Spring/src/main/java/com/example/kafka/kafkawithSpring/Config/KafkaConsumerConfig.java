package com.example.kafka.kafkawithSpring.Config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {

    //creating a value to hold the kafka URl to send the message
    @Value("${spring.kafka.bootstrap-servers}")
    private String boostrapServerUrl;

    //new we are config the producer with URL
    public Map<String, Object> consumerConfig(){
        Map<String, Object> props = new HashMap<>();
        //adding the URL
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,boostrapServerUrl);
        //adding the key value has string
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return props;
    }

    //creating consuer instances using consumer factor
    @Bean
    public ConsumerFactory<String, String> consumerFactory(){
        //sending consumerConfig has the parameter
        return new DefaultKafkaConsumerFactory<>(consumerConfig());
    }

    // listen contrainer factor recevise all message from all topic and partesion
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> factory (
            ConsumerFactory<String, String> consumerFactory){
        ConcurrentKafkaListenerContainerFactory<String, String> factory =
                                                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        return factory;
    }

}
