package com.dekankilic.notificationservice.service;

import com.dekankilic.notificationservice.entity.Notification;
import com.dekankilic.notificationservice.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;
    private final Logger logger = LoggerFactory.getLogger(NotificationService.class);

    public void save(Notification notification){
        Notification savedNotification = notificationRepository.save(notification);
        logger.info("NotificationService.save saved Id : {}", savedNotification.getId());
    }
}
