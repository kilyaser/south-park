package com.aston.southpark.controller;

import com.aston.southpark.dto.ProductDto;
import com.aston.southpark.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{id}")
    @Operation(summary = "Удаление информации о продукте")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное удаление", content = @Content(mediaType = "")),
            @ApiResponse(responseCode = "400", description = "Некорректный запрос", content = @Content(mediaType = "")),
            @ApiResponse(responseCode = "401", description = "Авторизуйтесь для операции", content = @Content(mediaType = "")),
            @ApiResponse(responseCode = "403", description = "доступ к запрошенному ресурсу запрещен", content = @Content(mediaType = "")),
            @ApiResponse(responseCode = "500", description = "Сервер занят, напишите позже", content = @Content(mediaType = "")),
    })
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getById(id));
    }

    @PostMapping("/{product}")
    @Operation(summary = "Добавление/обновление информации о продукте")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное удаление", content = @Content(mediaType = "")),
            @ApiResponse(responseCode = "400", description = "Некорректный запрос", content = @Content(mediaType = "")),
            @ApiResponse(responseCode = "401", description = "Авторизуйтесь для операции", content = @Content(mediaType = "")),
            @ApiResponse(responseCode = "403", description = "доступ к запрошенному ресурсу запрещен", content = @Content(mediaType = "")),
            @ApiResponse(responseCode = "500", description = "Сервер занят, напишите позже", content = @Content(mediaType = "")),
    })
    public ResponseEntity<?> createProduct(@RequestBody ProductDto productDto) {
        productService.createOrUpdate(productDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление информации о продукте")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное удаление", content = @Content(mediaType = "")),
            @ApiResponse(responseCode = "400", description = "Некорректный запрос", content = @Content(mediaType = "")),
            @ApiResponse(responseCode = "401", description = "Авторизуйтесь для операции", content = @Content(mediaType = "")),
            @ApiResponse(responseCode = "403", description = "доступ к запрошенному ресурсу запрещен", content = @Content(mediaType = "")),
            @ApiResponse(responseCode = "500", description = "Сервер занят, напишите позже", content = @Content(mediaType = "")),
    })
    public void remove(@PathVariable Long id) {
        productService.remove(id);
    }

}
