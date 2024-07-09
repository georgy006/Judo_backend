package com.example.judoStore.service.account.impl;

import com.example.judoStore.persistence.models.Customer;
import com.example.judoStore.persistence.models.RefreshToken;
import com.example.judoStore.persistence.repository.RefreshTokenRepository;
import com.example.judoStore.requests.AuthenticationRequestDto;
import com.example.judoStore.requests.CreateCustomerRequest;
import com.example.judoStore.responses.AuthenticationResponseDto;
import com.example.judoStore.service.CustomerService;
import com.example.judoStore.service.account.AccountService;
import com.example.judoStore.service.account.AuthorityService;
import com.example.judoStore.service.account.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.springframework.data.repository.util.ClassUtils.ifPresent;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    final PasswordEncoder passwordEncoder;
    final CustomerService service;
    final AuthenticationManager authenticationManager;
    final JwtService jwtService;
    final AuthorityService authorityService;
    final RefreshTokenRepository refreshTokenRepository;

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
    @Transactional
    public void logout() {
        Optional.ofNullable(authorityService.getCurrentUser())
                .ifPresent(customer -> refreshTokenRepository.deleteByCustomerId(customer.getId()));
    }

    private AuthenticationResponseDto authenticate(Customer customer) {
        refreshTokenRepository.deleteByCustomerId(customer.getId());
        return AuthenticationResponseDto.builder()
                .token(jwtService.generateToken(customer))
                .refreshToken(refreshTokenRepository.save(RefreshToken.builder()
                        .customer(customer)
                        .token(jwtService.generateRefreshToken(String.valueOf(customer.getId())))
                        .build()).getToken())
                .build();
    }
}
