package com.aston.southpark.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
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

    @Column(name = "customer", nullable = false)
    @ManyToOne
    private Customer customer;
    @Column(name = "created", nullable = false)
    private LocalDateTime created;
    @Column(name = "modified", nullable = false)
    private LocalDateTime modified;
    @Column(name = "total_cost", nullable = false)
    private BigDecimal totalCost;
    @Column(name = "completion", nullable = false)
    private LocalDateTime completion;

    @Column(name = "order_title", nullable = false)
    private String orderTitle;
    private boolean isComplected;

    private Payment payment;
}