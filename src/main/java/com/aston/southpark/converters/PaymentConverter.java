package com.aston.southpark.converters;

import com.aston.southpark.dto.PaymentDto;
import com.aston.southpark.model.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class PaymentConverter {

    public Payment toEntity(PaymentDto dto) {
        var payment = new Payment();
        if (dto.getId() != 0) payment.setId(dto.getId());
        payment.setAmount(dto.getAmount());
        return payment;
    }

    public PaymentDto toDto(Payment payment) {
        var dto = new PaymentDto();
        dto.setId(payment.getId());
        dto.setAmount(payment.getAmount());
        return dto;

    }
}
