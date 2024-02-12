package com.dekankilic.userservice.mapper;

import com.dekankilic.userservice.dto.UserCreateRequest;
import com.dekankilic.userservice.dto.UserCreatedResponse;
import com.dekankilic.userservice.entity.User;

import java.time.LocalDateTime;

public class UserMapper {
    public static UserCreatedResponse mapToUserCreatedDto(User user, UserCreatedResponse userCreatedResponse){
        userCreatedResponse.setFirstName(user.getFirstName());
        userCreatedResponse.setLastName(user.getLastName());
        userCreatedResponse.setEmail(user.getEmail());
        userCreatedResponse.setCreatedAt(LocalDateTime.now());
        userCreatedResponse.setUpdatedAt(LocalDateTime.now());
        return userCreatedResponse;
    }

    public static User mapToUser(UserCreateRequest userCreateRequest, User user){
        user.setFirstName(userCreateRequest.getFirstName());
        user.setLastName(userCreateRequest.getLastName());
        user.setEmail(userCreateRequest.getEmail());
        user.setCreatedAt(LocalDateTime.now());
        return user;
    }
}
