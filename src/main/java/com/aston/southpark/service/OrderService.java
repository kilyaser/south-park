package com.aston.southpark.service;

import com.aston.southpark.exception.ResourceNotFoundException;
import com.aston.southpark.model.Order;
import com.aston.southpark.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("Order with id: %d not found", id)));
    }
}
