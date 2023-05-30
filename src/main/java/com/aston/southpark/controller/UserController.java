package com.aston.southpark.controller;

import com.aston.southpark.converters.UserConverter;
import com.aston.southpark.dto.UserDto;
import com.aston.southpark.model.Role;
import com.aston.southpark.model.User;
import com.aston.southpark.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserConverter userConverter;

    @GetMapping
    public List<UserDto> getAllUsers(){
        return userService.findAllUsers().stream()
                .map(userConverter::entityToDto)
                .collect(Collectors.toList());
    }
    @GetMapping("/{username}")
    public UserDto getUserByUsername(@PathVariable String username) {
        return userConverter.entityToDto(userService.getUserByUsername(username));
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserDto dto) {
        System.out.println(dto);
        return userConverter.entityToDto(userService.createOrUpdate(userConverter.toEntity(dto)));
    }

    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable Long id, @RequestBody UserDto dto) {
        User newUser = userConverter.toEntity(dto);
        return userConverter.entityToDto(userService.createOrUpdate(newUser));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.remove(id);
    }
}
