package com.aston.southpark.service;

import com.aston.southpark.converters.OrderItemConverter;
import com.aston.southpark.dto.OrderItemDto;
import com.aston.southpark.exception.ResourceNotFoundException;
import com.aston.southpark.model.OrderItem;
import com.aston.southpark.repository.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderItemService {

    private final OrderItemConverter orderItemConverter;
    private final OrderItemRepository orderItemRepository;

    public OrderItemDto getById(Long id) {
        return orderItemConverter.mapToOrderItemDto(orderItemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("OrderItem with id = %d not found", id))));
    }

    public List<OrderItemDto> getAll() {
        return orderItemRepository.findAll().stream().map(orderItemConverter::mapToOrderItemDto).collect(Collectors.toList());
    }

    public OrderItem create(OrderItemDto dto) {
        return orderItemRepository.save(orderItemConverter.mapToOrderItemEntity(dto));
    }

    @Transactional
    public void remove(Long id) {
        orderItemRepository.delete(orderItemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("OrderItem with id = %d not found", id))));
    }

    @Transactional
    public void update(OrderItemDto dto) {
        OrderItem orderItem = orderItemRepository.findById(dto.getId()).orElseThrow(() -> new ResourceNotFoundException(String.format("OrderItem with id = %d not found", dto.getId())));
        orderItem.setId(dto.getId());
        orderItem.setQuantity(dto.getQuantity());
        orderItem.setPrice(dto.getPrice());
        orderItem.setPricePerProduct(dto.getPricePerProduct());
        orderItemRepository.save(orderItem);
    }
}