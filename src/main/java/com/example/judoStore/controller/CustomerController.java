package com.example.judoStore.controller;

import com.example.judoStore.persistence.models.Customer;
import com.example.judoStore.requests.CreateCustomerRequest;
import com.example.judoStore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

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
        return customerService.createCustomer(request);
    }


    @PostMapping(path = "/customer/{id}")
    public Customer updateCustomerById(@PathVariable(name = "id") Long id,@RequestBody CreateCustomerRequest request){
        return customerService.updateCustomerById(id,request);
    }

}
