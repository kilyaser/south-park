package com.aston.southpark.model;


import javax.persistence.*;

@Entity
@Table(name = "technologist")
public class Technologist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;

}
