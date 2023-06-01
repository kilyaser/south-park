package com.aston.southpark.controller;

import com.aston.southpark.dto.ProductDto;
import com.aston.southpark.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{product}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getById(id));
    }

    @PostMapping("/{product}")
    public ResponseEntity<?> createProduct(@RequestBody ProductDto productDto) {
        productService.createOrUpdate(productDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id) {
        productService.remove(id);
    }

}
