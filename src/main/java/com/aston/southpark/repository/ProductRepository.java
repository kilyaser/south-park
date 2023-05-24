package com.aston.southpark.repository;

import com.aston.southpark.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query("SELECT p FROM Product p WHERE p.productTitle =:title")
    Optional<Product> findByTitle (@Param("title") String title);
}
