package com.example.studioJudo.service.account.impl;

import com.example.studioJudo.dto.UserDto;
import com.example.studioJudo.models.Role;
import com.example.studioJudo.models.User;
import com.example.studioJudo.repositories.RoleRepository;
import com.example.studioJudo.repositories.UserRepository;
import com.example.studioJudo.requests.AuthenticationRequestDto;
import com.example.studioJudo.requests.CreateUserRequest;
import com.example.studioJudo.responses.AuthenticationResponseDto;
import com.example.studioJudo.service.UserService;
import com.example.studioJudo.service.account.AccountService;
import com.example.studioJudo.service.account.AuthorityService;
import com.example.studioJudo.service.account.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    final PasswordEncoder passwordEncoder;
    final UserService userService;
    final RoleRepository roleRepository;
    final UserRepository userRepository;
    final AuthenticationManager authenticationManager;
    final JwtService jwtService;
    final AuthorityService authorityService;
//    final RefreshTokenRepository refreshTokenRepository;

    @Override
    @Transactional
    public User signup(CreateUserRequest request) {
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setPhoneNumber(request.getPhoneNumber());

        Role role = roleRepository.findById(1)
                .orElseThrow(() -> new RuntimeException("Default role not found"));
        user.setRole(role);
        user.setIsTrainer(false);

        return userService.saveUser(user);
    }

    @Override
    @Transactional
    public AuthenticationResponseDto login(AuthenticationRequestDto authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.login(), authenticationRequest.password())
        );
        var user = userService.findUserByEmail(authenticationRequest.login());
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return login(user);
    }

//    @Override
//    @Transactional
//    public void logout() {
//        Optional.ofNullable(authorityService.getCurrentUser())
//                .ifPresent(customer -> refreshTokenRepository.deleteByCustomerId(customer.getId()));
//    }

    private AuthenticationResponseDto login(User user) {
//        refreshTokenRepository.deleteByCustomerId(user.getId());
        return AuthenticationResponseDto.builder()
                .token(jwtService.generateToken(user))
//                .refreshToken(refreshTokenRepository.save(RefreshToken.builder()
//                        .customer(user)
//                        .token(jwtService.generateRefreshToken(String.valueOf(user.getId())))
//                        .build()).getToken())
                .build();
    }
}
