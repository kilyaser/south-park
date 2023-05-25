package com.aston.southpark.controller;

import com.aston.southpark.dto.OrderDto;
import com.aston.southpark.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/orders")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
public class OrderController {
    private final OrderService orderService;
    @GetMapping
    @Operation(summary = "To get all orders from database")
    public List<OrderDto> getAllOrders() {
        return orderService.getAll();
    }

}
