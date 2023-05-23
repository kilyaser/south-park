package com.aston.southpark.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderDto {

    private Long id;

    private LocalDateTime created;

    private LocalDateTime modified;

    private BigDecimal totalCost;

    private LocalDateTime completion;

    private String orderName;

    private boolean isComplected;
}
