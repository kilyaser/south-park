package com.aston.southpark.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SecurityRequirement(name = "Bearer Authentication")
@RequestMapping("api/v1")
public class SouthParkController {
    @Operation(summary = "Health controller to check the health of the application")
    @GetMapping
    public String getSouthParkHello() {
        return "This is South Park project";
    }

    @Operation(summary = "The health controller is only available to authorized users")
    @GetMapping("/secured")
    public String getSecuredData() {
        return "This is very sensitive information, only for authorized users";
    }
}
