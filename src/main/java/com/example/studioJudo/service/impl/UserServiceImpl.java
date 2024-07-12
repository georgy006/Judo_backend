package com.example.studioJudo.service.impl;

import com.example.studioJudo.dto.UserDto;
import com.example.studioJudo.mapper.impl.UserMapper;
import com.example.studioJudo.models.Qualification;
import com.example.studioJudo.models.Role;
import com.example.studioJudo.models.User;
import com.example.studioJudo.repositories.QualificationRepository;
import com.example.studioJudo.repositories.RoleRepository;
import com.example.studioJudo.repositories.UserRepository;
import com.example.studioJudo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

//    private Mapper<UserDto, User> userMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private QualificationRepository qualificationRepository;

    //User
    @Override
    public List<UserDto> findAllUser() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .toList();
    }

    @Override // новое
    public UserDto findUserById(Integer id) {

        return userRepository.findById(id).stream()
                .map(userMapper::toDto)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found"));

//        Optional<User> userOptional = userRepository.findById(id);
//        if (userOptional.isPresent()) {
//            return userRepository.findById(id).stream()
//                    .map(userMapper::toDto)
//                    .findFirst()
//                    .orElseThrow();
////            return userOptional.get();
//        }
//        throw new RuntimeException();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }

    @Override
    public UserDto findUserByEmail(String email) {
        return userRepository.findUserByEmail(email).stream()
                .map(userMapper::toDto)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User by email not found"));
    }

    @Override
    public User saveUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User updateUser(Integer id, UserDto userDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setPhoneNumber(userDto.getPhoneNumber());

        Role role = roleRepository.findById(1)
                .orElseThrow(() -> new RuntimeException("Default role not found"));
        user.setRole(role);
        user.setIsTrainer(false);

        userRepository.save(user);
        return user;
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    //Client

    @Override
    public List<UserDto> findAllClient() {
        Role role = roleRepository.findById(1).orElseThrow(() -> new RuntimeException("Role not found"));
        return userRepository.findByRole(role).stream()
                .map(userMapper::toDto)
                .toList();
    }

    //Trainer
    @Override
    public List<UserDto> findAllTrainer() {
        Role role = roleRepository.findById(2).orElseThrow(() -> new RuntimeException("Role not found"));
        return userRepository.findByRole(role).stream()
                .map(userMapper::toDto)
                .toList();
    }

//    @Override
//    public UserDto findTrainerById(Integer id) {
//        Optional<User> userOptional = userRepository.findById(id);
//        if (userOptional.isPresent()) {
//            return userOptional.get();
//        }
//        throw new RuntimeException();
//    }


    @Override
    public User saveTrainer(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setPhoneNumber(userDto.getPhoneNumber());

        Role role = roleRepository.findById(2)
                .orElseThrow(() -> new RuntimeException("Default role not found"));
        user.setRole(role);

        user.setIsTrainer(true);
        Optional<Qualification> qualificationOptional = qualificationRepository.findById(userDto.getQualificationId());
        if (qualificationOptional.isPresent()) {
            user.setQualification(qualificationOptional.get());
        }

        userRepository.save(user);
        return user;
    }

    @Override
    public User updateTrainer(Integer id, UserDto userDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setPhoneNumber(userDto.getPhoneNumber());

        Role role = roleRepository.findById(2)
                .orElseThrow(() -> new RuntimeException("Default role not found"));
        user.setRole(role);

        user.setIsTrainer(true);
        Optional<Qualification> qualificationOptional = qualificationRepository.findById(userDto.getQualificationId());
        if (qualificationOptional.isPresent()) {
            user.setQualification(qualificationOptional.get());
        }

        userRepository.save(user);
        return user;
    }

    @Override
    public void deleteTrainer(Integer id) {
        userRepository.deleteById(id);
    }
}
