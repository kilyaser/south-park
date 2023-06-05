package com.aston.southpark.controller;

import com.aston.southpark.converters.CustomerConverter;
import com.aston.southpark.dto.CustomerDto;
import com.aston.southpark.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
public class CustomerController {
    private final CustomerService customerService;
    private final CustomerConverter customerConverter;

    @GetMapping
    @Operation(summary = "To get all customers from database")
    public List<CustomerDto> getAllCustomers() {
        return customerService.getAll();
    }

    @PostMapping
    public CustomerDto createCustomer(@RequestBody CustomerDto customerDto) {
        return customerConverter.toDto(customerService.create(customerDto));
    }


}
