package com.dekankilic.userservice.config.kafka.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
public class UserCreatedTopicProperties {
    @Value("${kafka.topics.user-created.topicName}")
    private String topicName;
    @Value("${kafka.topics.user-created.partitionCount}")
    private int partitionCount;
    @Value("${kafka.topics.user-created.replicationFactor}")
    private int replicationFactor;
    @Value("${kafka.topics.user-created.retentionInMs}")
    private String retentionInMs;
}
