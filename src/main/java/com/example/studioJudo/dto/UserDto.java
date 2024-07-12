package com.example.studioJudo.dto;

import lombok.*;

@Setter
@Getter
@Builder
public class UserDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private Boolean isTrainer;
    private Integer qualificationId;
    private Integer roleId;
}
