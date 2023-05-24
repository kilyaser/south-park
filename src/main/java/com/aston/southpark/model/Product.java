package com.aston.southpark.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Setter
@Getter
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_title", nullable = false)
    @NotBlank
    @Size(max = 255)
    private String productTitle;

    @Column(name = "product_type", nullable = false)
    @NotBlank
    @Size(max = 70)
    private String productType;

    @Column(name = "written_program", nullable = false)
    private boolean isProgramWritten;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "material_id")
    private Material material;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "preparation", columnDefinition = "enum")
    private Preparation preparation;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "technologist_id")
    private Technologist technologist;

}
