package com.fooddelivery.fooddeliveryapi.domain.repository;

import com.fooddelivery.fooddeliveryapi.domain.model.Cidade;
import com.fooddelivery.fooddeliveryapi.domain.model.Cozinha;

import java.util.List;

public interface CidadeRepository {
    List<Cidade> listarTodasCidade();

    Cidade buscarPorId(Long id);

    Cidade adicionar(Cidade cidade);

    void remover(Cidade cidade);

}
