package com.example.studioJudo.service.impl;

import com.example.studioJudo.dto.UserDto;
import com.example.studioJudo.enumeration.RoleName;
import com.example.studioJudo.models.Qualification;
import com.example.studioJudo.models.Role;
import com.example.studioJudo.models.User;
import com.example.studioJudo.repositories.QualificationRepository;
import com.example.studioJudo.repositories.RoleRepository;
import com.example.studioJudo.repositories.UserRepository;
import com.example.studioJudo.requests.CreateUserRequest;
import com.example.studioJudo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private QualificationRepository qualificationRepository;

    //User
    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override // новое
    public User findUserById(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            return userOptional.get();
        }
        throw new RuntimeException();
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return userRepository.findUserByEmail(username).get();
//    }
//
//    @Override
//    public UserDto findUserByEmail(String email) {
//        return userRepository.findUserByEmail(email).get();
//    }

    @Override
    public User saveUser(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setPhoneNumber(userDto.getPhoneNumber());

        Role role = roleRepository.findById(1)
                .orElseThrow(() -> new RuntimeException("Default role not found"));
        user.setRole(role);
        user.setIsTrainer(false);

//        if(userDto.getRoleId() == 2) {
//            user.setIsTrainer(true);
//            Optional<Qualification> qualification = qualificationRepository.findById(userDto.getQualificationId());
//            if (qualification.isPresent()) {
//                user.setQualification(qualification.get());
//            }
//        } else {
//            user.setIsTrainer(false);
//        }


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

//        if(userDto.getRoleId() == 2) {
//            user.setIsTrainer(true);
//            Optional<Qualification> qualification = qualificationRepository.findById(userDto.getQualificationId());
//            if (qualification.isPresent()) {
//                user.setQualification(qualification.get());
//            }
//        } else {
//            user.setIsTrainer(false);
//        }

        userRepository.save(user);
        return user;
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    //Client

    @Override
    public List<User> findAllClient() {
        Role role = roleRepository.findById(1).orElseThrow(() -> new RuntimeException("Role not found"));
        return userRepository.findByRole(role);
    }

    //Trainer
    @Override
    public List<User> findAllTrainer() {
        Role role = roleRepository.findById(2).orElseThrow(() -> new RuntimeException("Role not found"));
        return userRepository.findByRole(role);
    }

    @Override
    public User findTrainerById(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            return userOptional.get();
        }
        throw new RuntimeException();
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return userRepository.findUserByEmail(username).get();
//    }
//
//    @Override
//    public UserDto findUserByEmail(String email) {
//        return userRepository.findUserByEmail(email).get();
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
