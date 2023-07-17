package com.fooddelivery.fooddeliveryapi.domain.repository;

import com.fooddelivery.fooddeliveryapi.domain.model.Cozinha;
import com.fooddelivery.fooddeliveryapi.domain.model.Estado;

import java.util.List;

public interface EstadoRepository {

    List<Estado> listarTodosEstados();
    Estado buscarPorId(Long id);
    Estado adicionar(Estado estado);
    void remover(Long id);
}
