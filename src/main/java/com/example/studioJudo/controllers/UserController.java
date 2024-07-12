package com.example.studioJudo.controllers;

import com.example.studioJudo.dto.UserDto;
import com.example.studioJudo.models.User;
import com.example.studioJudo.requests.AuthenticationRequestDto;
import com.example.studioJudo.requests.CreateUserRequest;
import com.example.studioJudo.responses.AuthenticationResponseDto;
import com.example.studioJudo.service.UserService;
import com.example.studioJudo.service.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    AccountService accountService;

    @GetMapping
    public List<UserDto> findAllUser() {
        return userService.findAllUser();
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") Integer id) {
        return userService.findUserById(id);
    }

    @PostMapping
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") Integer id, @RequestBody UserDto userDto){
        return userService.updateUser(id, userDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id){
        userService.deleteUser(id);
    }

    // Нахождение всех клиентов

    @GetMapping("/client")
    public List<User> findAllClient() {
        return userService.findAllClient();
    }

    // создание, редактирование и удаление тренера!

    @GetMapping("/trainer")
    public List<User> findAllTrainer() {
        return userService.findAllTrainer();
    }

    @GetMapping("/trainer/{id}")
    public User findTrainerById(@PathVariable("id") Integer id) {
        return userService.findTrainerById(id);
    }

    @PostMapping("/trainer")
    public User saveTrainer(@RequestBody UserDto userDto) {
        return userService.saveTrainer(userDto);
    }

    @PutMapping("/trainer/{id}")
    public User updateTrainer(@PathVariable("id") Integer id, @RequestBody UserDto userDto){
        return userService.updateTrainer(id, userDto);
    }

    @DeleteMapping("/trainer/{id}")
    public void deleteTrainer(@PathVariable("id") Integer id){
        userService.deleteTrainer(id);
    }

    @PostMapping("/login")
    public AuthenticationResponseDto login(@RequestBody AuthenticationRequestDto request){
        return accountService.login(request);
    }

    @PostMapping("/signup")
    public User signup(@RequestBody CreateUserRequest request){
        return accountService.signup(request);
    }

//    @PostMapping(path = "/logout")
//    public ResponseEntity<Void> logout() {
//        accountService.logout();
//        return ResponseEntity.noContent().build();
//    }

}