package com.dekankilic.userservice.service;

import com.dekankilic.userservice.config.kafka.producer.KafkaProducer;
import com.dekankilic.userservice.config.kafka.properties.UserCreatedTopicProperties;
import com.dekankilic.userservice.dto.UserCreateRequest;
import com.dekankilic.userservice.dto.UserCreatedDto;
import com.dekankilic.userservice.entity.User;
import com.dekankilic.userservice.mapper.UserMapper;
import com.dekankilic.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final KafkaProducer kafkaProducer;
    private final UserCreatedTopicProperties userCreatedTopicProperties;

    public User create(UserCreateRequest userCreateRequest){
        User user = UserMapper.mapToUser(userCreateRequest, new User());
        User createdUser = userRepository.save(user);

        UserCreatedDto payload = UserCreatedDto.getUserCreatedDto(createdUser, userCreateRequest.getAddressText());

        Map<String, Object> headers = new HashMap<>();
        headers.put(KafkaHeaders.TOPIC, userCreatedTopicProperties.getTopicName());
        headers.put(KafkaHeaders.KEY, createdUser.getId().toString());

        kafkaProducer.sendMessage(new GenericMessage<>(payload, headers));
        return createdUser;
    }
}
