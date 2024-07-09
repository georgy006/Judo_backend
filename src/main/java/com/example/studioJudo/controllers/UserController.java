package com.example.studioJudo.controllers;

import com.example.studioJudo.dto.UserDto;
import com.example.studioJudo.models.User;
import com.example.studioJudo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> findAllUser() {
        return userService.findAllUser();
    }

    @PostMapping
    public User saveUser(@RequestBody UserDto userDto) {
        return userService.saveUser(userDto);
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") Integer id) {
        return userService.findUserById(id);
    }

//    @GetMapping("/{id}") // Новое
//    public UserDto findUserById(@PathVariable("id") Integer id) {
//        return userService.findUserById(id);
//    }

    @PutMapping("/{id}") // Старое без id
    public User updateUser(@PathVariable("id") Integer id, @RequestBody UserDto userDto){
        return userService.updateUser(id, userDto);
    }

//    @PutMapping("/{id}") // Новое с id
//    public User updateUser(@PathVariable(name = "id") Integer id, @RequestBody User user){
//        return userService.updateUser(id, user);
//    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id){
        userService.deleteUser(id);
    }

}