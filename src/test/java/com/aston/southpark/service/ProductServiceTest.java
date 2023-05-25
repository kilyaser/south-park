package com.aston.southpark.service;

import com.aston.southpark.converters.ProductConverter;
import com.aston.southpark.dto.ProductDto;
import com.aston.southpark.exception.ResourceNotFoundException;
import com.aston.southpark.model.Material;
import com.aston.southpark.model.Preparation;
import com.aston.southpark.model.Technologist;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductConverter productConverter;
    @Test
    void getById() {

        var productDB = productService.getById(1L);

        assertAll(
                () -> assertEquals("pro1", productDB.getProductTitle()),
                () -> assertEquals("type1", productDB.getProductType()),
                () -> assertTrue(productDB.isProgramWritten()),
                () -> assertEquals(Preparation.NEW.name(), productDB.getPreparation())
        );
    }

    @Test
    void getAll() {
        long count = productService.getAll().size();
        assertTrue(count > 0);
    }

    @Test
    void create() {
        ProductDto newProduct = new ProductDto();
        Material material = new Material();
        material.setId(1L);
        material.setType("steel");

        Technologist technologist = new Technologist();
        technologist.setId(1L);
        technologist.setName("Ivan");
        technologist.setEmail("ivan@mail.ru");

        newProduct.setProductTitle("newProd");
        newProduct.setProductType("newType");
        newProduct.setProgramWritten(true);
        newProduct.setEndDate(null);
        newProduct.setPreparation(Preparation.NEW.name());


        productService.createOrUpdate(newProduct);

        ProductDto createdProduct = productService.getById(2L);

        assertEquals(2, createdProduct.getId());
        assertEquals(newProduct.getProductTitle(), createdProduct.getProductTitle());
        assertEquals(newProduct.getProductType(), createdProduct.getProductType());
    }

    @Test
    void update() {

//        ProductDto dtoToUpdate = productConverter.entityToDto(TEST_PROD);
//        dtoToUpdate.setProductTitle("newTitle");
//        dtoToUpdate.setProductType("newType");
//
//        productService.createOrUpdate(dtoToUpdate);
//        ProductDto updatedDto = productService.getById(dtoToUpdate.getId());
//
//        assertEquals(dtoToUpdate.getProductTitle(), updatedDto.getProductTitle());
//        assertEquals(dtoToUpdate.getProductType(), updatedDto.getProductType());
    }

    @Test
    void delete() {
//        productService.remove(TEST_PROD.getId());
//
//        assertThrows(ResourceNotFoundException.class, () -> productService.getById(TEST_PROD.getId()));
    }
}