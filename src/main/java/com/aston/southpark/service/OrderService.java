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
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderConverter orderConverter;

    public OrderDto getById(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("Order with id = %d not found", id)));
        return orderConverter.mapToOrderDto(order);
    }

    public OrderDto getByName(String name) {
        return orderConverter.mapToOrderDto(orderRepository.findByOrderTitle(name).orElseThrow(() -> new ResourceNotFoundException(String.format("Order with order_title = %s not found", name))));
    }

    public List<OrderDto> getAll() {
        return orderRepository.findAll().stream().map(orderConverter::mapToOrderDto).collect(Collectors.toList());
    }

    public Order create(OrderDto dto) {
        return orderRepository.save(orderConverter.mapToOrderEntity(dto));
    }

    @Transactional
    public void remove(Long id) {
        orderRepository.delete(orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("Order with id = %d not found", id))));
    }

    @Transactional
    public void update(OrderDto dto) {
        Order order = orderRepository.findById(dto.getId()).orElseThrow(() -> new ResourceNotFoundException(String.format("Order with id = %d not found", dto.getId())));
        order.setCreated(dto.getCreated());
        order.setModified(dto.getModified());
        order.setTotalCost(dto.getTotalCost());
        order.setCompletion(dto.getCompletion());
        order.setOrderTitle(dto.getOrderTitle());
        order.setComplected(dto.isComplected());
        orderRepository.save(order);
    }
}
