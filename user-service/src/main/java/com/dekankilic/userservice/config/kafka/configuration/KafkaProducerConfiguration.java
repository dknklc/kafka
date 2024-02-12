package com.dekankilic.userservice.config.kafka.configuration;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfiguration {
    @Value("${kafka.host}")
    private String kafkaBrokers; // This is the variable that holds bootstrap servers.

    @Bean
    public KafkaTemplate<String, ?> kafkaTemplate() { // We need a way for us to send messages. This is possible with KafkaTemplate.
        return new KafkaTemplate<>(producerConfig());
    }

    private ProducerFactory<String, ?> producerConfig() { // This is responsible for creating Kafka producer instances
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBrokers);
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class); // We will send Json.
        return new DefaultKafkaProducerFactory<>(config);
    }
}
