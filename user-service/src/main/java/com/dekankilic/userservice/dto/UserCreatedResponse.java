package com.dekankilic.userservice.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserCreatedResponse {
    private String firstName;
    private String lastName;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
