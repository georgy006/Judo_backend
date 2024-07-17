package com.example.judoStore.controller;

import com.example.judoStore.persistence.models.Customer;
import com.example.judoStore.requests.AuthenticationRequestDto;
import com.example.judoStore.requests.CreateCustomerRequest;
import com.example.judoStore.responses.AuthenticationResponseDto;
import com.example.judoStore.service.CustomerService;
import com.example.judoStore.service.account.AccountService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @Autowired
    AccountService accountService;

    @GetMapping(path = "/customers")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping(path = "/customer/{id}")
    public Customer getCustomerById(@PathVariable(name = "id") Long id){
        return customerService.getCustomerById(id);
    }

    @DeleteMapping(path = "/customer/{id}")
    public void deleteCustomerById(@PathVariable(name = "id") Long id){
        customerService.deleteCustomerById(id);
    }

    @PostMapping(path = "/customer")
    public Customer createCustomer(@RequestBody CreateCustomerRequest request){
//        return customerService.createCustomer(request);
        return null;
    }


    @PostMapping(path = "/customer/{id}")
    public Customer updateCustomerById(@PathVariable(name = "id") Long id,@RequestBody CreateCustomerRequest request){
        return customerService.updateCustomerById(id,request);
    }

    @PostMapping(path = "/customer/login")
    public AuthenticationResponseDto login(@RequestBody AuthenticationRequestDto request){
        return accountService.authenticate(request);
    }

    @PostMapping(path = "/customer/register")
    public Customer register(@RequestBody CreateCustomerRequest request){
        return accountService.register(request);
    }

    @PostMapping(path = "/customers/logout")
    public ResponseEntity<Void> logout(HttpServletRequest request) {
        accountService.logout(request);
        return ResponseEntity.noContent().build();
    }
}
