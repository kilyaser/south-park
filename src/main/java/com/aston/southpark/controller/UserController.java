package com.aston.southpark.controller;

import com.aston.southpark.converters.UserConverter;
import com.aston.southpark.dto.UserDto;
import com.aston.southpark.model.User;
import com.aston.southpark.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "User controller", description = "Operation with user for Admin")
@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
public class UserController {

    private final UserService userService;
    private final UserConverter userConverter;

    @GetMapping
    @Operation(summary = "Get all users")
    public List<UserDto> getAllUsers() {
        return userService.findAllUsers().stream()
                .map(userConverter::entityToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{username}")
    @Operation(summary = "Get users by username")
    public UserDto getUserByUsername(@PathVariable String username) {
        return userConverter.entityToDto(userService.getUserByUsername(username));
    }

    @PostMapping
    @Operation(summary = "Create new user")
    @ResponseStatus(code = HttpStatus.CREATED)
    public UserDto createUser(@RequestBody UserDto dto) {
        System.out.println(dto);
        return userConverter.entityToDto(userService.createOrUpdate(userConverter.toEntity(dto)));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update user by id")
    public UserDto updateUser(@PathVariable Long id, @RequestBody UserDto dto) {
        User newUser = userConverter.toEntity(dto);
        return userConverter.entityToDto(userService.createOrUpdate(newUser));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete user by id")
    public void deleteUser(@PathVariable Long id) {
        userService.remove(id);
    }
}
