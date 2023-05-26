package com.aston.southpark.service;

import com.aston.southpark.converters.OrderConverter;
import com.aston.southpark.dto.OrderDto;
import com.aston.southpark.model.Order;
import com.aston.southpark.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.aston.southpark.exception.ResourceNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Order getById(Long id) {
        return orderRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(String.format("Order with id = %d not found", id)));
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Order create(Order order) {
        return orderRepository.save(order);
    }

    @Transactional
    public Order update(Order order) {
       return orderRepository.save(order);
    }
}
