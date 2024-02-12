package com.dekankilic.userservice.controller;

import com.dekankilic.userservice.dto.UserCreateRequest;
import com.dekankilic.userservice.dto.UserCreatedResponse;
import com.dekankilic.userservice.entity.User;
import com.dekankilic.userservice.mapper.UserMapper;
import com.dekankilic.userservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserCreatedResponse> create(@RequestBody UserCreateRequest userCreateRequest){
        User createdUser = userService.create(userCreateRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(UserMapper.mapToUserCreatedDto(createdUser, new UserCreatedResponse()));
    }
}
