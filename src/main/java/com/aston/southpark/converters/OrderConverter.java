package com.aston.southpark.converters;

import com.aston.southpark.dto.OrderDto;
import com.aston.southpark.model.Order;
import org.springframework.stereotype.Service;


@Service
public class OrderConverter {

    public OrderDto mapToOrderDto(Order order) {
        var dto = new OrderDto();
        dto.setId(order.getId());
        dto.setCreated(order.getCreated());
        dto.setModified(order.getModified());
        dto.setTotalCost(order.getTotalCost());
        dto.setCompletion(order.getCompletion());
        dto.setOrderName(order.getName());
        dto.setComplected(order.isComplected());
        return dto;
    }

    public Order mapToOrderEntity(OrderDto orderDto) {
        var order = new Order();
        orderDto.setId(order.getId());
        orderDto.setCreated(order.getCreated());
        orderDto.setModified(order.getModified());
        orderDto.setTotalCost(order.getTotalCost());
        orderDto.setCompletion(order.getCompletion());
        orderDto.setOrderName(order.getName());
        orderDto.setComplected(order.isComplected());
        return order;
    }
}