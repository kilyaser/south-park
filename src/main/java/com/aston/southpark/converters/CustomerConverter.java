package com.aston.southpark.converters;

import com.aston.southpark.dto.CustomerDto;
import com.aston.southpark.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter {

    public Customer toEntity(CustomerDto dto) {
        return new Customer();                  //FIXME: реализовать метод
    }
    public CustomerDto toDto(Customer customer) {
        return new CustomerDto();               //FIXME: реализовать метод
    }
}
