package com.aston.southpark.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class SouthParkController {
    @GetMapping
    public String getSouthParkHello() {
        return "This is South Park project";
    }

    @GetMapping("/secured")
    public String getSecuredData() {
        return "This is very sensitive information, only for authorized users";
    }
}
