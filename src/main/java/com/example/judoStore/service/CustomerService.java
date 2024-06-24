package com.example.judoStore.service;

import com.example.judoStore.persistence.models.Customer;
import com.example.judoStore.persistence.models.Product;
import com.example.judoStore.requests.CreateCustomerRequest;
import com.example.judoStore.requests.CreateProductRequest;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer getCustomerById(Long id);
    void deleteCustomerById(Long id);
    Customer createCustomer(CreateCustomerRequest request);
}
