package com.example.judoStore.service.account.impl;

import com.example.judoStore.persistence.models.Customer;
import com.example.judoStore.requests.AuthenticationRequestDto;
import com.example.judoStore.requests.CreateCustomerRequest;
import com.example.judoStore.responses.AuthenticationResponseDto;
import com.example.judoStore.service.CustomerService;
import com.example.judoStore.service.account.AccountService;
import com.example.judoStore.service.account.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    final CustomerService service;
    final AuthenticationManager authenticationManager;
    final JwtService jwtService;

    @Override
    @Transactional
    public Customer register(CreateCustomerRequest request) {
        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setEmail(request.getEmail());
        customer.setPassword(passwordEncoder.encode(request.getPassword()));
        customer.setCity(request.getCity());
        customer.setPhoneNumber(request.getPhoneNumber());
        return service.createCustomer(customer);
    }

    @Override
    @Transactional
    public AuthenticationResponseDto authenticate(AuthenticationRequestDto authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.login(), authenticationRequest.password())
        );
        var user = service.getCustomerByEmail(authenticationRequest.login());
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return authenticate(user);
    }

    @Override
    public void logout() {

    }

    private AuthenticationResponseDto authenticate(Customer user) {
//        refreshTokenRepository.deleteByUserId(user.getId());
        return AuthenticationResponseDto.builder()
                .token(jwtService.generateToken(user))
//                .refreshToken(refreshTokenRepository.save(RefreshToken.builder()
//                        .user(user)
//                        .token(jwtService.generateRefreshToken(String.valueOf(user.getId())))
//                        .build()).getToken())
                .build();
    }
}
