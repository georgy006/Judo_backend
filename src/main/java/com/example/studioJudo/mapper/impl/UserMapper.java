package com.example.studioJudo.mapper.impl;

import com.example.studioJudo.dto.UserDto;
import com.example.studioJudo.mapper.Mapper;
import com.example.studioJudo.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements Mapper<UserDto, User> {

    @Override
    public UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .lastName(user.getLastName())
                .firstName(user.getFirstName())
                .phoneNumber(user.getPhoneNumber())
                .isTrainer(user.getIsTrainer())
                .build();
    }

    @Override
    public User toEntity(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .password(userDto.getPassword())
                .email(userDto.getEmail())
                .lastName(userDto.getLastName())
                .firstName(userDto.getFirstName())
                .phoneNumber(userDto.getPhoneNumber())
                .isTrainer(userDto.getIsTrainer())
                .build();
    }

}
