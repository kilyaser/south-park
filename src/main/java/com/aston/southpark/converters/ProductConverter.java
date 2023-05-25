package com.aston.southpark.converters;

import com.aston.southpark.dto.ProductDto;

import com.aston.southpark.model.Preparation;
import com.aston.southpark.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class ProductConverter {
    private final TechnologistConverter technologistConverter;
    private final MaterialConverter materialConverter;

    public ProductDto entityToDto(Product product) {
        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setProductTitle(product.getProductTitle());
        dto.setProductType(product.getProductType());
        dto.setProgramWritten(product.isProgramWritten());
        dto.setMaterialDto(materialConverter.toDto(product.getMaterial()));
        dto.setEndDate(product.getEndDate());
        dto.setPreparation(product.getPreparation().name());
        dto.setTechnologistDto(technologistConverter.entityToDto(product.getTechnologist()));
        return dto;
    }

    public Product toEntity(ProductDto dto) {
        Product product = new Product();
        product.setProductTitle(dto.getProductTitle());
        product.setProductType(dto.getProductType());
        product.setProgramWritten(dto.isProgramWritten());
        product.setMaterial(materialConverter.toEntity(dto.getMaterialDto()));
        product.setPreparation(Preparation.valueOf(dto.getPreparation()));
        product.setTechnologist(technologistConverter.toEntity(dto.getTechnologistDto()));
        if (Objects.nonNull(dto.getEndDate())) {
            product.setEndDate(dto.getEndDate());
        }
        if (Objects.nonNull(dto.getId())) {
            product.setId(dto.getId());
        }
        return product;
    }
}
