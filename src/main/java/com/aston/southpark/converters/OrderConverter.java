package com.aston.southpark.converters;

import com.aston.southpark.dto.OrderDto;
import com.aston.southpark.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component
@RequiredArgsConstructor
public class OrderConverter {

    private final CustomerConverter customerConverter;

    public OrderDto mapToOrderDto(Order order) {
        var dto = new OrderDto();
        dto.setId(order.getId());
        dto.setCreated(order.getCreated());
        dto.setModified(order.getModified());
        dto.setTotalCost(order.getTotalCost());
        dto.setCompletion(order.getCompletion());
        dto.setOrderTitle(order.getOrderTitle());
        dto.setComplected(order.isComplected());
        dto.setCustomerDto(customerConverter.toDto(order.getCustomer()));
        return dto;
    }

    public Order mapToOrderEntity(OrderDto orderDto) {
        var order = new Order();
        order.setId(orderDto.getId());
        order.setCreated(orderDto.getCreated());
        order.setModified(orderDto.getModified());
        order.setTotalCost(orderDto.getTotalCost());
        order.setCompletion(orderDto.getCompletion());
        order.setOrderTitle(orderDto.getOrderTitle());
        order.setComplected(orderDto.isComplected());
        order.setCustomer(customerConverter.toEntity(orderDto.getCustomerDto()));
        return order;
    }
}