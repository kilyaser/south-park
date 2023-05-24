package com.aston.southpark.service;

import com.aston.southpark.converters.ProductConverter;
import com.aston.southpark.dto.ProductDto;
import com.aston.southpark.exception.ResourceNotFoundException;
import com.aston.southpark.model.Material;
import com.aston.southpark.model.Preparation;
import com.aston.southpark.model.Product;
import com.aston.southpark.model.Technologist;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Sql(scripts = "classpath:src/test/product-test.sql", config = @SqlConfig(encoding = "UTF-8"), executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class ProductServiceTest {

    @Autowired
    private ProductService service;

    @Autowired
    private ProductConverter converter;

    private static final Product TEST_PROD = new Product();
    private static final String PRODUCT_TITLE = "pro1";

    @BeforeAll
    static void initProduct() {

        Material material = new Material();
        material.setId(1L);
        material.setType("material");

        Technologist technologist = new Technologist();
        technologist.setId(1L);
        technologist.setName("Ivan");
        technologist.setEmail("ivan@mail.ru");

        TEST_PROD.setId(1L);
        TEST_PROD.setProductTitle("pro1");
        TEST_PROD.setProductType("type1");
        TEST_PROD.setProgramWritten(true);
        TEST_PROD.setMaterial(material);
        TEST_PROD.setEndDate(null);
        TEST_PROD.setPreparation(Preparation.NEW);
        TEST_PROD.setTechnologist(technologist);
    }

    @Test
    void getById() {

        ProductDto actualProduct = service.getById(TEST_PROD.getId());

        assertEquals(TEST_PROD.getId(), actualProduct.getId());
        assertEquals(TEST_PROD.getProductTitle(), actualProduct.getProductTitle());
        assertEquals(TEST_PROD.getProductType(), actualProduct.getProductType());
    }

    @Test
    void getByTitle() {

        ProductDto actualProduct = service.getByTitle(PRODUCT_TITLE);

        assertEquals(TEST_PROD.getId(), actualProduct.getId());
        assertEquals(TEST_PROD.getProductTitle(), actualProduct.getProductTitle());
        assertEquals(TEST_PROD.getProductType(), actualProduct.getProductType());
    }

    @Test
    void getAll() {

        ProductDto dto = converter.entityToDto(TEST_PROD);

        assertEquals(List.of(dto), service.getAll());
    }

    @Test
    void create() {
        ProductDto newProduct = new ProductDto();
        Material material = new Material();
        material.setId(1L);
        material.setType("material");

        Technologist technologist = new Technologist();
        technologist.setId(1L);
        technologist.setName("Ivan");
        technologist.setEmail("ivan@mail.ru");

        newProduct.setProductTitle("newProd");
        newProduct.setProductType("newType");
        newProduct.setProgramWritten(true);
        newProduct.setMaterial(material.getType());
        newProduct.setEndDate(null);
        newProduct.setPreparation(Preparation.NEW.name());
        newProduct.setTechnologist(technologist.getName());

        service.createOrUpdate(newProduct);

        ProductDto createdProduct = service.getById(2L);

        assertEquals(2, createdProduct.getId());
        assertEquals(newProduct.getProductTitle(), createdProduct.getProductTitle());
        assertEquals(newProduct.getProductType(), createdProduct.getProductType());
    }

    @Test
    void update() {

        ProductDto dtoToUpdate = converter.entityToDto(TEST_PROD);
        dtoToUpdate.setProductTitle("newTitle");
        dtoToUpdate.setProductType("newType");

        service.createOrUpdate(dtoToUpdate);
        ProductDto updatedDto = service.getById(dtoToUpdate.getId());

        assertEquals( dtoToUpdate.getProductTitle(), updatedDto.getProductTitle());
        assertEquals( dtoToUpdate.getProductType(), updatedDto.getProductType());
    }

    @Test
    void delete() {
        service.remove(TEST_PROD.getId());

        assertThrows(ResourceNotFoundException.class, () -> service.getById(TEST_PROD.getId()));
    }
}