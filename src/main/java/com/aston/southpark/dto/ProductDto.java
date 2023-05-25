package com.aston.southpark.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String productTitle;
    private String productType;
    private boolean isProgramWritten;
    private MaterialDto materialDto;
    private LocalDateTime endDate;
    private String preparation;
    private TechnologistDto technologistDto;
}
