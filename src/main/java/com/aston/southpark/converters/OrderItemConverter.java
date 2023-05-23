package com.aston.southpark.converters;

import com.aston.southpark.dto.OrderItemDto;
import com.aston.southpark.model.OrderItem;
import org.springframework.stereotype.Service;

@Service
public class OrderItemConverter {


    public OrderItemDto mapToOrderItemDto(OrderItem orderItem) {
        var dto = new OrderItemDto();
        dto.setId(orderItem.getId());
        dto.setQuantity(orderItem.getQuantity());
        dto.setPrice(orderItem.getPrice());
        dto.setPricePerProduct(orderItem.getPricePerProduct());
        return dto;
    }

    public OrderItem mapToOrderItemEntity(OrderItemDto orderItemDto) {
        var orderItem = new OrderItem();
        orderItemDto.setId(orderItem.getId());
        orderItemDto.setQuantity(orderItem.getQuantity());
        orderItemDto.setPricePerProduct(orderItem.getPrice());
        orderItemDto.setPricePerProduct(orderItem.getPricePerProduct());
        return orderItem;
    }
}
