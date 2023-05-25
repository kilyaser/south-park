package com.aston.southpark.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemDto {

    private Long id;

    private int quantity;

    private BigDecimal price;

    private BigDecimal pricePerProduct;
}