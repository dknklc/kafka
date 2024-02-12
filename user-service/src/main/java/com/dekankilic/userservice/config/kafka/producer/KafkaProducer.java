package com.dekankilic.userservice.config.kafka.producer;

import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;
import java.util.concurrent.CompletableFuture;


// Let's see how we are going to use our producer which is kind of a microservice and send a message to our topic that we have defined.
@Component
@RequiredArgsConstructor
public class KafkaProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

    public void sendMessage(GenericMessage message){

        final CompletableFuture<SendResult<String, Object>> listenableResult = kafkaTemplate.send(message);

        listenableResult.whenComplete((result, ex) -> {
            if(ex == null){
                logger.info("Message :{} published, topic :{}, partition :{} and offset :{}", message.getPayload(),
                        result.getRecordMetadata().topic(),
                        result.getRecordMetadata().partition(),
                        result.getRecordMetadata().offset()
                );
            } else{
                logger.error("Unable to deliver message to Kafka", ex);
            }
        });
    }
}

