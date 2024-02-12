package com.dekankilic.notificationservice.config.kafka.configuration.consumer;

import com.dekankilic.notificationservice.config.kafka.configuration.model.UserCreatedEvent;
import com.dekankilic.notificationservice.entity.Notification;
import com.dekankilic.notificationservice.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


// let's write the code that allows us to consume events from our topic

@Component
@RequiredArgsConstructor
public class UserCreatedEventConsumer {
    private final NotificationService notificationService;
    private final Logger logger = LoggerFactory.getLogger(UserCreatedEventConsumer.class);

    @KafkaListener(topics = "${kafka.topics.user-created.topic}",
            groupId = "${kafka.topics.user-created.consumerGroup}",
            containerFactory = "concurrentKafkaListenerContainerFactory"
    )
    public void consumeCreatedUserEvent(@Payload UserCreatedEvent eventData, @Headers ConsumerRecord<String, Object> consumerRecord){
        logger.info("UserCreatedEventConsumer.consumeApprovalRequestResultedEvent consumed EVENT : {} " +
                "from partition : {} " +
                "with offset : {} " +
                "thread : {} " +
                "for message key : {}",
                eventData, consumerRecord.partition(), consumerRecord.offset(), Thread.currentThread().getName(), consumerRecord.key()
        );

        Notification notification = UserCreatedEvent.getNotificationFromEvent(eventData);
        notificationService.save(notification);
    }
}

