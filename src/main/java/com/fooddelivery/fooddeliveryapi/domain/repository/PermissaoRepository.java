package com.fooddelivery.fooddeliveryapi.domain.repository;

import com.fooddelivery.fooddeliveryapi.domain.model.Cozinha;
import com.fooddelivery.fooddeliveryapi.domain.model.Permissao;

import java.util.List;

public interface PermissaoRepository {
    List<Permissao> listarTodasPermissao();

    Permissao buscarPorId(Long id);

    Permissao adicionar(Permissao permissao);

    void remover(Permissao permissao);

}
