package com.aston.southpark.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class OrderDto {

    private Long id;

    private LocalDateTime created;

    private LocalDateTime modified;

    private BigDecimal totalCost;

    private LocalDateTime completion;

    private String orderTitle;

    private boolean isComplected;

    private CustomerDto customerDto;
}
