package com.aston.southpark.mapper;

import com.aston.southpark.dto.CustomerDto;
import com.aston.southpark.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", source = "id")
    CustomerDto convertToDto(Customer customer);

    @Mapping(target = "id", source = "id")
    Customer convertToEntity(CustomerDto customerDto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "phone", source = "phone")
    Customer initCustomerDto(CustomerDto customerDto, Long id);
}
