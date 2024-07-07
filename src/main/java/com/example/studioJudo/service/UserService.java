package com.example.studioJudo.service;

import com.example.studioJudo.dto.UserDto;
import com.example.studioJudo.models.Client;
import com.example.studioJudo.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAllUser();
    Optional<User> findUserById(Integer id);
    User saveUser(User user);
    User updateUser(User user);
    void deleteUser(Integer id);
}
