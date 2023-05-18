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

    @OneToMany(mappedBy = "customer")
    private List<Payment> payment;

    @PrePersist
    public void onCreate() {
        created = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        modified = LocalDateTime.now();
    }

    public void addTask(Task task) {
    }
}