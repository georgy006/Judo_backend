package com.example.studioJudo.service.impl;

import com.example.studioJudo.dto.UserDto;
import com.example.studioJudo.repositories.UserRepository;
import com.example.studioJudo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDto> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserDto> findUserById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        return userRepository.save(userDto);
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        return userRepository.save(userDto);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

}
