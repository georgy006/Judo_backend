package com.example.studioJudo.service;

import com.example.studioJudo.dto.UserDto;
import com.example.studioJudo.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    // User
    List<UserDto> findAllUser();
    UserDto findUserById(Integer id);

    User saveUser(User user);
    User updateUser(Integer id, UserDto userDto);
    void deleteUser(Integer id);

    UserDto findUserByEmail(String email);

    // Client
    List<UserDto> findAllClient();

    // Trainer
    List<UserDto> findAllTrainer();
    //UserDto findTrainerById(Integer id); // Пока не придумал как вывести определенного тренера учитывая роль!
    // Решил пока что сделать только findUserById

    User saveTrainer(UserDto userDto);
    User updateTrainer(Integer id, UserDto userDto);
    void deleteTrainer(Integer id);
}
