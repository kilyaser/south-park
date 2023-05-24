package com.aston.southpark.converters;

import com.aston.southpark.dto.OrderDto;
import com.aston.southpark.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter {
    public Order toEntity(OrderDto dto) {
        return new Order();                 //FIXME: реализовать метод
    }

    public OrderDto toDto(Order order) {
        return new OrderDto();          //FIXME: реализовать метод
    }
}
