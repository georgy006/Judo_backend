package com.example.studioJudo.service;

import com.example.studioJudo.dto.UserDto;
import com.example.studioJudo.models.User;

import java.util.List;
public interface UserService { //extends UserDetailsService

    // User
    List<User> findAllUser();
    User findUserById(Integer id);
    User saveUser(UserDto userDto);
    User updateUser(Integer id, UserDto userDto);
    void deleteUser(Integer id);

    //    UserDto findUserByEmail(String email);

    // Client
    List<User> findAllClient();

    // Trainer
    List<User> findAllTrainer();
    User findTrainerById(Integer id);
    User saveTrainer(UserDto userDto);
    User updateTrainer(Integer id, UserDto userDto);
    void deleteTrainer(Integer id);
}
