package com.example.studioJudo.service;

import com.example.studioJudo.dto.UserDto;
import com.example.studioJudo.models.Client;
import com.example.studioJudo.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserDto> findAllUser();

    Optional<UserDto> findUserById(Integer id);

    UserDto saveUser(UserDto userDto);

    UserDto updateUser(UserDto userDto);

    void deleteUser(Integer id);

}
