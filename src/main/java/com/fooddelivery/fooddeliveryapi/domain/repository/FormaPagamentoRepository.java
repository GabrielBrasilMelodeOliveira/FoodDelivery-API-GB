package com.fooddelivery.fooddeliveryapi.domain.repository;

import com.fooddelivery.fooddeliveryapi.domain.model.Estado;
import com.fooddelivery.fooddeliveryapi.domain.model.FormaPagamento;

import java.util.List;

public interface FormaPagamentoRepository {
    List<FormaPagamento> listarTodasFormaPagamento();
    FormaPagamento buscarPorId(Long id);
    FormaPagamento adicionar(FormaPagamento formaPagamento);
    void remover(Long id);
}
