package com.aston.southpark.converters;

import com.aston.southpark.dto.PaymentDto;
import com.aston.southpark.model.Payment;
import com.aston.southpark.service.CustomerService;
import com.aston.southpark.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;


@Component
@RequiredArgsConstructor
public class PaymentConverter {
    private final OrderService orderService;
    private final CustomerService customerService;

    public Payment toEntity(PaymentDto dto) {
        var payment = new Payment();
        if (Objects.nonNull(dto.getId())) payment.setId(dto.getId());
        payment.setOrder(orderService.getById(dto.getOrderId()));
        payment.setCustomer(customerService.getCustomerById(dto.getCustomerId()));
        payment.setAmount(dto.getAmount());
        return payment;
    }

    public PaymentDto toDto(Payment payment) {
        var dto = new PaymentDto();
        dto.setId(payment.getId());
        dto.setOrderId(payment.getOrder().getId());
        dto.setCustomerId(payment.getCustomer().getId());
        dto.setAmount(payment.getAmount());
        return dto;

    }
}
