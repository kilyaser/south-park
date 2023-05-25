package com.aston.southpark.converters;

import com.aston.southpark.dto.CustomerDto;
import com.aston.southpark.dto.MaterialDto;
import com.aston.southpark.model.Customer;
import com.aston.southpark.model.Material;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class MaterialConverter {

    public Material toEntity(MaterialDto materialDto) {
        Material material = new Material();
        material.setType(materialDto.getType());
        return material;
    }
    public MaterialDto toDto(Material material) {
        MaterialDto materialDto = new MaterialDto();
        materialDto.setId(material.getId());
        materialDto.setType(materialDto.getType());
        return materialDto;
    }
}
