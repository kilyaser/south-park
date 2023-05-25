package com.aston.southpark.service;

import com.aston.southpark.converters.CustomerConverter;
import com.aston.southpark.converters.OrderConverter;
import com.aston.southpark.converters.PaymentConverter;
import com.aston.southpark.dto.PaymentDto;
import com.aston.southpark.exception.ResourceNotFoundException;
import com.aston.southpark.model.Payment;
import com.aston.southpark.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentConverter paymentConverter;
    private final OrderConverter orderConverter;
    private final CustomerConverter customerConverter;


    public Payment create(PaymentDto dto) {
        return paymentRepository.save(paymentConverter.toEntity(dto));
    }

    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

    public Payment getById(Long id) {
        return paymentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("Payment with id = %d not found", id)));
    }

    @Transactional
    public void remove(Long id) {
        paymentRepository.delete(paymentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("Payment with id = %d not found", id))));
    }
    @Transactional
    public void update(PaymentDto dto) {
        var payment = paymentRepository.findById(dto.getId()).orElseThrow(() -> new ResourceNotFoundException(String.format("Payment with id = %d not found", dto.getId())));
        payment.setOrder(orderConverter.mapToOrderEntity(dto.getOrderDto()));
        payment.setCustomer(customerConverter.toEntity(dto.getCustomerDto()));
        payment.setAmount(dto.getAmount());
        paymentRepository.save(payment);
    }

    //TODO: написать тесты ко всем методам после реализации Order и Customer классов их сервисов и ковертеров


}
