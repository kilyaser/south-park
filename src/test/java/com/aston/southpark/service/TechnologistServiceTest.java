package com.aston.southpark.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TechnologistServiceTest {
    @Autowired
    private TechnologistService technologistService;
    @Test
    public void getTechnologistTest() {
        var tech = technologistService.getById(1L);
        assertAll(
                () -> assertEquals(1L, tech.getId()),
                () -> assertEquals("Ivan", tech.getName()),
                () -> assertEquals("ivan@mail.ru", tech.getEmail()));
    }


}
