package com.aston.southpark.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerDto {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private OrderDto orderDto;

}
