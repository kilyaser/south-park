package com.aston.southpark.service;

import com.aston.southpark.converters.MaterialConverter;
import com.aston.southpark.dto.MaterialDto;
import com.aston.southpark.exception.ResourceNotFoundException;
import com.aston.southpark.model.Material;
import com.aston.southpark.repository.MaterialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MaterialService {

    private final MaterialRepository materialRepository;
    private final MaterialConverter materialConverter;

    public Material create(MaterialDto materialDto) {
        return materialRepository.save(materialConverter.toEntity(materialDto));
    }

    public MaterialDto getById(Long id) {
        return materialConverter.toDto(materialRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Material with id = %d not found", id))));
    }

    @Transactional
    public void remove(Long id) {
        materialRepository.delete(materialRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Material with id = %d not found", id))));
    }

    @Transactional
    public void update(MaterialDto materialDto) {
        Material material = materialRepository.findById(materialDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Material with id = %d not found", materialDto.getId())));
        material.setType(materialDto.getType());
    }

}
