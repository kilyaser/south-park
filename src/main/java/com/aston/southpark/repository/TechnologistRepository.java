package com.aston.southpark.repository;

import com.aston.southpark.model.Technologist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface TechnologistRepository extends JpaRepository<Technologist, Long> {
    Optional<Technologist> findByName(String name);
}
