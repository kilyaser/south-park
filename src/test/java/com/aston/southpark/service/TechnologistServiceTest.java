package com.aston.southpark.service;


import com.aston.southpark.dto.TechnologistDto;
import com.aston.southpark.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TechnologistServiceTest {
    @Autowired
    private TechnologistService technologistService;

    @Test
    public void getTechnologistByIdTest() {
        var tech = technologistService.getById(1L);
        assertAll(
                () -> assertEquals(1L, tech.getId()),
                () -> assertEquals("Ivan", tech.getName()),
                () -> assertEquals("ivan@mail.ru", tech.getEmail())
        );
    }

    @Test
    public void getTechnologistByNameTest() {
        var tech = technologistService.getByName("Andrey");
        assertAll(
                () -> assertEquals("Andrey", tech.getName()),
                () -> assertEquals("andrey@mail.ru", tech.getEmail()));
    }

    @Test
    public void createTest() {
        var techDto = new TechnologistDto();
        techDto.setName("new technologist");
        techDto.setEmail("new@mail.ru");
        var tech = technologistService.create(techDto);

        assertAll(
                () -> assertEquals("new technologist", tech.getName()),
                () -> assertEquals("new@mail.ru", tech.getEmail())
        );

    }

    @Test
    public void removeTest() {
        var tech = technologistService.getById(2L);

        assertEquals(tech.getName(), "Petr");

        technologistService.remove(2L);

        assertThrows(ResourceNotFoundException.class, () -> technologistService.getById(2L));

    }

    @Test
    public void updateTest() {
        var tech = technologistService.getById(1L);
        assertAll(
                () -> assertEquals("Ivan", tech.getName()),
                () -> assertEquals("ivan@mail.ru", tech.getEmail())
        );

        var techDto = new TechnologistDto();
        techDto.setId(1L);
        techDto.setName("updated Ivan");
        techDto.setEmail("updated@mail.ru");

        technologistService.update(techDto);
        var updatedTech = technologistService.getById(1L);

        assertAll(
                () -> assertNotEquals("Ivan", updatedTech.getName()),
                () -> assertNotEquals("ivan@mail.ru", updatedTech.getEmail()),

                () -> assertEquals("updated Ivan", updatedTech.getName()),
                () -> assertEquals("updated@mail.ru", updatedTech.getEmail())
        );


    }

}
