package com.aston.southpark.dto;

import com.aston.southpark.model.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Collection;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String username;
    private String password;
    private String email;
    private Collection<Role> roles;
}
