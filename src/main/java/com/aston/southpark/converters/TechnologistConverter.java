package com.aston.southpark.converters;

import com.aston.southpark.dto.TechnologistDto;
import com.aston.southpark.model.Technologist;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class TechnologistConverter {

    public TechnologistDto entityToDto(Technologist technologist) {
        var dto = new TechnologistDto();
        dto.setId(technologist.getId());
        dto.setName(technologist.getName());
        dto.setEmail(technologist.getEmail());
        return dto;
    }

    public Technologist toEntity(TechnologistDto dto) {
        var technologist = new Technologist();
        technologist.setName(dto.getName());
        if (Objects.nonNull(dto.getEmail())) technologist.setEmail(dto.getEmail());
        return technologist;
    }
}
