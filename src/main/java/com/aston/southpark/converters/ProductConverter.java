package com.aston.southpark.converters;

import com.aston.southpark.dto.ProductDto;
import com.aston.southpark.model.Material;
import com.aston.southpark.model.Preparation;
import com.aston.southpark.model.Product;
import com.aston.southpark.repository.MaterialRepository;
import com.aston.southpark.repository.TechnologistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ProductConverter {

   private TechnologistRepository technologistRepository;
   private MaterialRepository materialRepository;

   @Autowired
    public ProductConverter(TechnologistRepository technologistRepository, MaterialRepository materialRepository) {
        this.technologistRepository = technologistRepository;
        this.materialRepository = materialRepository;
    }

    public ProductDto entityToDto(Product product) {
        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setProductTitle(product.getProductTitle());
        dto.setProductType(product.getProductType());
        dto.setProgramWritten(product.isProgramWritten());
        dto.setMaterial(product.getMaterial().getType());
        dto.setEndDate(product.getEndDate());
        dto.setPreparation(product.getPreparation().name());
        dto.setTechnologist(product.getTechnologist().getName());
        return dto;
    }

    public Product toEntity(ProductDto dto) {
        Product product = new Product();

        product.setProductTitle(dto.getProductTitle());
        product.setProductType(dto.getProductType());
        product.setProgramWritten(dto.isProgramWritten());
        product.setMaterial(materialRepository.findByType(dto.getMaterial()).orElse(null));
        product.setPreparation(Preparation.valueOf(dto.getPreparation()));
        product.setTechnologist(technologistRepository.findByName(dto.getTechnologist()).orElse(null));
        if (Objects.nonNull(dto.getEndDate())) {
            product.setEndDate(dto.getEndDate());
        }
        if (Objects.nonNull(dto.getId())) {
            product.setId(dto.getId());
        }
        return product;
    }
}
