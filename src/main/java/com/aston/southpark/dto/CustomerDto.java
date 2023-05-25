package com.aston.southpark.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CustomerDto {
    private Long id;
    private String name;
    private String email;
    private String phone;

}
