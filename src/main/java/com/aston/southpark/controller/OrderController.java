package com.aston.southpark.controller;

import com.aston.southpark.converters.OrderConverter;
import com.aston.southpark.dto.OrderDto;
import com.aston.southpark.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("api/v1/orders")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
public class OrderController {
    private final OrderService orderService;
    private final OrderConverter orderConverter;
    @GetMapping
    @Operation(summary = "To get all orders from database")
    public List<OrderDto> getAllOrders() {
        return orderService.getAll().stream().map(orderConverter::mapToOrderDto).collect(Collectors.toList());
    }

    @PostMapping
    public OrderDto createOrder(@RequestBody OrderDto orderDto) {
        return orderConverter.mapToOrderDto(
                orderService.create(orderConverter.mapToOrderEntity(orderDto)));
    }

}
