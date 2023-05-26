package com.aston.southpark.controller;

import com.aston.southpark.converters.PaymentConverter;
import com.aston.southpark.dto.PaymentDto;
import com.aston.southpark.service.PaymentService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/payments")
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;
    private final PaymentConverter paymentConverter;

    @PostMapping
    public PaymentDto addPayment(@RequestBody PaymentDto dto) {
        return paymentConverter.toDto(paymentService.create(dto));
    }
}
