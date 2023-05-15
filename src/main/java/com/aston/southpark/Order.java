package com.aston.southpark;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Customer customer;
    private LocalDateTime created;
    private LocalDateTime modified;
    private BigDecimal totalCost;
    private LocalDateTime completion;
    private OrderItem orderItems;
    private String orderTitle;
    private boolean isComplected;
    private Payment payment;


}
