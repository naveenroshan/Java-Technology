package com.example.kafka.kafkawithSpring.Config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class kafkaProducerCongif {

    //creating a value to hold the kafka URl to send the message
    @Value("${spring.kafka.bootstrap-servers}")
    private String boostrapServerUrl;

    //new we are config the producer with URL
    public Map<String, Object> producerConfig(){
        Map<String, Object> props = new HashMap<>();
        //adding the URL
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,boostrapServerUrl);
        //adding the key value has string
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return props;
    }

    //creating producer instances using Producer factor
    @Bean
    public ProducerFactory<String, String> producerFactory(){
        //sending producerConfig has the parameter
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }

    //Sending message using kafka template
    @Bean
    public KafkaTemplate<String, String> kafkaTemplate(ProducerFactory<String, String> producerFactory){
        return new KafkaTemplate<>(producerFactory);
    }
}
