package com.aston.southpark.service;

import com.aston.southpark.converters.CustomerConverter;
import com.aston.southpark.converters.OrderConverter;
import com.aston.southpark.dto.CustomerDto;
import com.aston.southpark.exception.ResourceNotFoundException;
import com.aston.southpark.model.Customer;
import com.aston.southpark.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerConverter customerConverter;
    private final OrderConverter orderConverter;

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Customer with id: %d not found", id)));
    }

    public Customer create(CustomerDto customerDto) {
        return customerRepository.save(customerConverter.toEntity(customerDto));
    }
    @Transactional
    public void remove(Long id) {
        customerRepository.delete(customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Customer with id = %d not found", id))));
    }

    public List<CustomerDto> getAll() {
        return customerRepository.findAll().stream().map(customerConverter::toDto).collect(Collectors.toList());
    }

    @Transactional
    public void update(CustomerDto customerDto) {
        Customer customer = customerRepository.findById(customerDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Customer with id = %d not found", customerDto.getId())));
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setPhone(customerDto.getPhone());
    }
}