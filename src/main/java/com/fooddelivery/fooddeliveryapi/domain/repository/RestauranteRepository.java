package com.fooddelivery.fooddeliveryapi.domain.repository;

import com.fooddelivery.fooddeliveryapi.domain.model.Restaurante;

import java.util.List;

public interface RestauranteRepository {
    List<Restaurante> listar();
    Restaurante buscarPorId(Long id);

    Restaurante adicionar(Restaurante restaurante);

    void remover(Restaurante restaurante);
}
