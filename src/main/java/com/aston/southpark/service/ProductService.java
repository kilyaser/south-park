package com.aston.southpark.service;

import com.aston.southpark.converters.ProductConverter;
import com.aston.southpark.dto.ProductDto;
import com.aston.southpark.exception.ResourceNotFoundException;
import com.aston.southpark.model.Product;
import com.aston.southpark.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;
    private final ProductConverter productConverter;

    public Product getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Product with id = %d not found", id)));

    }

    public List<ProductDto> getAll() {
        return repository.findAll().stream()
                .map(productConverter::entityToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public Product createOrUpdate(ProductDto dto) {
        return repository.save(productConverter.toEntity(dto));
    }

    @Transactional
    public void remove(Long id) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Product with id = %d not found", id)));
        repository.delete(product);
    }
}
