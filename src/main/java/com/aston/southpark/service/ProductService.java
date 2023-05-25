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

    public ProductDto getById(Long id) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Product with id = %d not found", id)));
        return productConverter.entityToDto(product);
    }

    public ProductDto getByTitle(String title){
        Product product = repository.findByTitle(title)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Product with title = %s not found", title)));
        return productConverter.entityToDto(product);
    }

    public List<ProductDto> getAll() {
        return repository.findAll().stream()
                .map(p -> productConverter.entityToDto(p))
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
