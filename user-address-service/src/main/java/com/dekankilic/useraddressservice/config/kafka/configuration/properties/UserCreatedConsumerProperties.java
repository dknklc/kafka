package com.dekankilic.useraddressservice.config.kafka.configuration.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
public class UserCreatedConsumerProperties {
    @Value("${kafka.topics.user-created.topic}")
    private String topic;
    @Value("${kafka.topics.user-created.consumerGroup}")
    private String consumerGroup;
}
