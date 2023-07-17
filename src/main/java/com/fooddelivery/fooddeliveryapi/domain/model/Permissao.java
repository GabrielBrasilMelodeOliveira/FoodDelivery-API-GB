package com.fooddelivery.fooddeliveryapi.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Permissao {

    @Id
    @EqualsAndHashCode.Include
    private Long id;

    private String nome;

    private String descricao;
}
