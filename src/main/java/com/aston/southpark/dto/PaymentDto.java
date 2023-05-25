package com.aston.southpark.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class PaymentDto {
    private Long id;
    private BigDecimal amount;
}
