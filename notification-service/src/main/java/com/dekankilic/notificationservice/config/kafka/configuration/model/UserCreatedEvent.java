package com.dekankilic.notificationservice.config.kafka.configuration.model;

import com.dekankilic.notificationservice.entity.Notification;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreatedEvent {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    public static Notification getNotificationFromEvent(UserCreatedEvent event){
        return Notification.builder()
                .userId(event.getId())
                .email(event.getEmail())
                .isSend(Boolean.TRUE)
                .build();
    }
}
