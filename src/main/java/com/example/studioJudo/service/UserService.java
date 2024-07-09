package com.example.studioJudo.service;

import com.example.studioJudo.dto.UserDto;
import com.example.studioJudo.models.User;

import java.util.List;
public interface UserService { //extends UserDetailsService

    List<User> findAllUser();

    User findUserById(Integer id);

//    UserDto findUserById(Integer id); // Новое

//    UserDto findUserByEmail(String email);

    User saveUser(UserDto userDto);

    User updateUser(Integer id, UserDto userDto);

    void deleteUser(Integer id);

}
