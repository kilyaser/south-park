package com.aston.southpark.converters;

import com.aston.southpark.dto.OrderDto;
import com.aston.southpark.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class OrderConverter {

    private final CustomerConverter customerConverter;
    private final OrderItemConverter orderItemConverter;
    private final PaymentConverter paymentConverter;

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
        dto.setOrderItemDtos(order.getOrderItems().stream().map(orderItemConverter::mapToOrderItemDto).collect(Collectors.toList()));
        dto.setPaymentDtos(order.getPayments().stream().map(paymentConverter::toDto).collect(Collectors.toList()));
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
        order.setOrderItems(orderDto.getOrderItemDtos().stream().map(orderItemConverter::mapToOrderItemEntity).collect(Collectors.toList()));
        order.setPayments(orderDto.getPaymentDtos().stream().map(paymentConverter::toEntity).collect(Collectors.toList()));
        return order;
    }
}