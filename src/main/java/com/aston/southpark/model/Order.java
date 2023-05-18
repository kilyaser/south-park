package com.aston.southpark.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.scheduling.config.Task;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "customer")
    @ManyToOne
    @JoinColumn(name = "customer")
    private Customer customer;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "modified")
    private LocalDateTime modified;

    @Column(name = "total_cost")
    private BigDecimal totalCost;

    @Column(name = "completion")
    private LocalDateTime completion;

    @Column(name = "order_title")
    private String orderTitle;

    private boolean isComplected;

    @OneToMany(mappedBy = "customer")
    private List<Payment> payment;

    @PrePersist
    public void onCreate() {
        created = LocalDateTime.now();
        modified = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        modified = LocalDateTime.now();
    }

}