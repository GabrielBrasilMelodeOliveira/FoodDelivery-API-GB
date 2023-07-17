package com.fooddelivery.fooddeliveryapi.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Objects;
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Restaurante {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(name="taxa_frete",nullable = false)
    private BigDecimal taxaFrete;

    @ManyToOne
    //@JoinColumn(name = "hehehe")
    @JoinColumn(nullable = false)
    private Cozinha cozinha;

}
