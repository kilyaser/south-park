//package com.aston.southpark.service;
//
//import com.aston.southpark.dto.OrderDto;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest
//public class OrderServiceTest {
//
//    @Autowired
//    private static OrderService orderService;
//
//    @Test
//    public void getOrderByIdTest() {
//        OrderDto orderDto = orderService.getById(1L);
//        assertEquals("авто", orderDto.getOrderTitle());
//    }
//}