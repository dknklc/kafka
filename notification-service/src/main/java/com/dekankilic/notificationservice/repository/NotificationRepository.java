package com.dekankilic.notificationservice.repository;

import com.dekankilic.notificationservice.entity.Notification;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends CouchbaseRepository<Notification, String> {
}
