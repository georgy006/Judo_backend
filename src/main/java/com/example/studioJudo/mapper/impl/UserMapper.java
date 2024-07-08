package com.example.studioJudo.mapper.impl;

import com.example.studioJudo.dto.UserDto;
import com.example.studioJudo.mapper.Mapper;
import com.example.studioJudo.models.Qualification;
import com.example.studioJudo.models.Role;
import com.example.studioJudo.models.User;
import org.springframework.stereotype.Component;

import static java.util.Objects.nonNull;

@Component
public class UserMapper implements Mapper<UserDto, User> {

    @Override
    public UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .password(user.getPassword())
                .email(user.getEmail())
                .lastName(user.getLastName())
                .firstName(user.getFirstName())
                .phoneNumber(user.getPhoneNumber())
                .isTrainer(user.getIsTrainer())
                .roleId(nonNull(user.getRole()) ? user.getRole().getId() : null)
                .qualificationId(nonNull(user.getQualification()) ? user.getQualification().getId() : null)
                .build();
    }

    @Override
    public User toEntity(UserDto userDto) {
        return User.builder()
                .id(userDto.id())
                .password(userDto.password())
                .email(userDto.email())
                .lastName(userDto.lastName())
                .firstName(userDto.firstName())
                .phoneNumber(userDto.phoneNumber())
                .isTrainer(userDto.isTrainer())
                .role(nonNull(userDto.roleId())
                        ? Role.builder().id(userDto.roleId()).build()
                        : null)
                .qualification(nonNull(userDto.qualificationId())
                        ? Qualification.builder().id(userDto.qualificationId()).build()
                        : null)
                .build();
    }

}