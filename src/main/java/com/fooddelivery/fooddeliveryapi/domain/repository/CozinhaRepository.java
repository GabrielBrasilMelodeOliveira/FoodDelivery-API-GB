package com.fooddelivery.fooddeliveryapi.domain.repository;

import com.fooddelivery.fooddeliveryapi.domain.model.Cozinha;

import java.util.List;

public interface CozinhaRepository {
    List<Cozinha> listarTodasCozinhas();
    Cozinha buscarPorId(Long id);
    Cozinha adicionar(Cozinha cozinha);
    void remover(Cozinha cozinha);
}
