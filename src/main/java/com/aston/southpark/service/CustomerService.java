package com.aston.southpark.service;

import com.aston.southpark.exception.ResourceNotFoundException;
import com.aston.southpark.model.Customer;
import com.aston.southpark.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("Customer with id: %d not found", id)));
    }
}
