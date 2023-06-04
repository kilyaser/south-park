package com.aston.southpark.service;

import com.aston.southpark.converters.UserConverter;
import com.aston.southpark.exception.ResourceNotFoundException;
import com.aston.southpark.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private UserConverter userConverter;

    @Test
    void getByNameTest() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User userBd = userService.getUserByUsername("Admin");

        assertAll(
                () -> assertEquals("Admin", userBd.getUsername()),
                () -> assertEquals("$2y$10$0iw5joKWfZs60TICdRjoD.Ca1O9vZRVsZ768nGZHlGWu83KBo0kqe", userBd.getPassword()),
                () -> assertEquals("admin@mail.com", userBd.getEmail())
        );
    }

    @Test
    void getAllTest() {
        int size = userService.findAllUsers().size();
        assertEquals(3, size);
    }

    @Test
    void createUpdateTest() {
        User newUser = new User();
        newUser.setUsername("newUser");
        newUser.setPassword("newPass");
        newUser.setEmail("newEmail");

        User savedUser = userService.createOrUpdate(newUser);

        assertEquals(newUser.getUsername(), savedUser.getUsername());
        assertEquals(newUser.getPassword(), savedUser.getPassword());
        assertEquals(newUser.getEmail(), savedUser.getEmail());

        savedUser.setUsername("Renamed username");

        User updatedUser = userService.createOrUpdate(savedUser);

        assertEquals(savedUser.getUsername(), updatedUser.getUsername());
    }

    @Test
    void deleteTest() {
        User user = userService.getUserByUsername("TEST");

        assertAll(
                () -> assertEquals(3L, user.getId()),
                () -> assertEquals("manager@mail.com", user.getEmail())
        );
        userService.remove(user.getId());

        assertThrows(ResourceNotFoundException.class,
                () -> userService.getUserByUsername("TEST"));

    }
}
