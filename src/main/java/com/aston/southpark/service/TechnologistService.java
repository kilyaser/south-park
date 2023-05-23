package com.aston.southpark.service;


import com.aston.southpark.converters.TechnologistConverter;
import com.aston.southpark.dto.TechnologistDto;
import com.aston.southpark.exception.ResourceNotFoundException;
import com.aston.southpark.repository.TechnologistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TechnologistService {

    private final TechnologistRepository technologistRepository;
    private final TechnologistConverter technologistConverter;

    public TechnologistDto getById(Long id) {
        var technologist = technologistRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("Technologist with id = %d not found", id)));
        return technologistConverter.entityToDto(technologist);
    }

    public TechnologistDto getByName(String name) {
        return technologistConverter.entityToDto(technologistRepository.findByName(name).orElseThrow(() -> new ResourceNotFoundException(String.format("Technologist with name = %s not found", name))));
    }

    public void create(TechnologistDto dto) {
        technologistRepository.save(technologistConverter.toEntity(dto));
    }

    @Transactional
    public void remove(Long id) {
        var technologist = technologistRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("Technologist with name = %d not found", id)));
        technologistRepository.delete(technologistRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("Technologist with id = %d not found", id))));
    }

    public void update(TechnologistDto dto) {
        technologistRepository.save(technologistConverter.toEntity(dto));
    }


}
