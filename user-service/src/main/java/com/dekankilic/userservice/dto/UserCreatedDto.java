package com.dekankilic.userservice.dto;

import com.dekankilic.userservice.entity.User;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UserCreatedDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String addressText;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static UserCreatedDto getUserCreatedDto(User user, String addressText){
        return UserCreatedDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .addressText(addressText)
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }
}
