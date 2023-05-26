package com.aston.southpark.service;

import com.aston.southpark.dto.OrderItemDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class OrderItemServiceTest {

    @Autowired
    private OrderItemService orderItemServiceService;

    @Test
    public void getOrderItemByIdTest() {
        OrderItemDto orderItemDto = orderItemServiceService.getById(1L);
        assertEquals(200000, orderItemDto.getPrice());
    }
}