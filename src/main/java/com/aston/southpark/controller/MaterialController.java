package com.aston.southpark.controller;

import com.aston.southpark.dto.MaterialDto;
import com.aston.southpark.service.MaterialService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/material")
@RequiredArgsConstructor
public class MaterialController {

    private final MaterialService materialService;

    @GetMapping("/{material}")
    @Operation(summary = "Получение информации о материалах")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное получение", content = @Content(mediaType = "")),
            @ApiResponse(responseCode = "400", description = "Некорректный запрос", content = @Content(mediaType = "")),
            @ApiResponse(responseCode = "401", description = "Авторизуйтесь для операции", content = @Content(mediaType = "")),
            @ApiResponse(responseCode = "403", description = "доступ к запрошенному ресурсу запрещен", content = @Content(mediaType = "")),
            @ApiResponse(responseCode = "500", description = "Сервер занят, напишите позже", content = @Content(mediaType = "")),
    })
    public ResponseEntity<?> getMaterialById(@PathVariable Long id) {
        return ResponseEntity.ok(materialService.getById(id));
    }

    @PostMapping("/{material}")
    @Operation(summary = "Добавление/обновление информации о материалах")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное добавление/обновлние", content = @Content(mediaType = "")),
            @ApiResponse(responseCode = "400", description = "Некорректный запрос", content = @Content(mediaType = "")),
            @ApiResponse(responseCode = "401", description = "Авторизуйтесь для операции", content = @Content(mediaType = "")),
            @ApiResponse(responseCode = "403", description = "доступ к запрошенному ресурсу запрещен", content = @Content(mediaType = "")),
            @ApiResponse(responseCode = "500", description = "Сервер занят, напишите позже", content = @Content(mediaType = "")),
    })
    public ResponseEntity<?> createMaterial(@RequestBody MaterialDto materialDto) {
        materialService.create(materialDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление информации о материалах")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное удаление", content = @Content(mediaType = "")),
            @ApiResponse(responseCode = "400", description = "Некорректный запрос", content = @Content(mediaType = "")),
            @ApiResponse(responseCode = "401", description = "Авторизуйтесь для операции", content = @Content(mediaType = "")),
            @ApiResponse(responseCode = "403", description = "доступ к запрошенному ресурсу запрещен", content = @Content(mediaType = "")),
            @ApiResponse(responseCode = "500", description = "Сервер занят, напишите позже", content = @Content(mediaType = "")),
    })
    public void deleteMaterial(@PathVariable Long id) {
        materialService.remove(id);
    }


}
