package com.aston.southpark.converters;

import com.aston.southpark.dto.PaymentDto;
import com.aston.southpark.model.Customer;
import com.aston.southpark.model.Payment;
import com.aston.southpark.service.CustomerService;
import com.aston.southpark.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class PaymentConverter {
    private final CustomerService customerService;
    private final OrderService orderService;
    private final OrderConverter orderConverter;
    private final CustomerConverter customerConverter;

    public Payment toEntity(PaymentDto dto) {
        var payment = new Payment();
        if (dto.getId() != 0) payment.setId(dto.getId());
        payment.setCustomer(null);                              //FIXME: Реализовать после того как будет реализован CustomerDto и CustomerConverter
        payment.setOrder(null);                                 //FiXME: Реализовать после того как будет реализован OrderDto и OrderConverter
        payment.setAmount(dto.getAmount());
        return payment;
    }

    public PaymentDto toDto(Payment payment) {
        var dto = new PaymentDto();
        dto.setId(payment.getId());
        dto.setCustomerDto(null);               //FIXME: Реализовать после того как будет реализован CustomerDto и CustomerConverter
        dto.setOrderDto(null);                  //FiXME: Реализовать после того как будет реализован OrderDto и OrderConverter
        dto.setAmount(payment.getAmount());
        return dto;

    }
}
