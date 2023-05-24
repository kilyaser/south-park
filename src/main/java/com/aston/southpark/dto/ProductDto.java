package com.aston.southpark.dto;

import com.aston.southpark.model.Material;
import com.aston.southpark.model.Preparation;
import com.aston.southpark.model.Technologist;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ProductDto {

    private Long id;

    private String productTitle;

    private String productType;

    private boolean isProgramWritten;

    private String material;

    private LocalDateTime endDate;

    private String preparation;

    private String technologist;
}
