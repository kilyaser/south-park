package com.aston.southpark.controller;

import com.aston.southpark.converters.MaterialConverter;
import com.aston.southpark.dto.MaterialDto;
import com.aston.southpark.service.MaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/material")
@RequiredArgsConstructor
public class MaterialController {

    private final MaterialService materialService;
    private final MaterialConverter materialConverter;

    @GetMapping("/{material}")
    public ResponseEntity<?> getMaterialById(@PathVariable Long id) {
        return ResponseEntity.ok(materialService.getById(id));
    }

    @PostMapping("/{material}")
    public ResponseEntity<?> createMaterial(@RequestBody MaterialDto materialDto) {
        materialService.create(materialDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public void deleteMaterial(@PathVariable Long id) {
        materialService.remove(id);
    }


}
