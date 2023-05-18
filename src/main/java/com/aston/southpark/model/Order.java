package com.aston.southpark.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    private Customer customer;
    private LocalDateTime created;
    private LocalDateTime modified;
    private BigDecimal totalCost;
    private LocalDateTime completion;

    @Column(name = "order_title", nullable = false)
    private String orderTitle;
    private boolean isComplected;

    private Payment payment;
}