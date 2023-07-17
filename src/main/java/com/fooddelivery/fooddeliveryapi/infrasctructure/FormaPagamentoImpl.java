package com.fooddelivery.fooddeliveryapi.infrasctructure;

import com.fooddelivery.fooddeliveryapi.domain.model.Estado;
import com.fooddelivery.fooddeliveryapi.domain.model.FormaPagamento;
import com.fooddelivery.fooddeliveryapi.domain.repository.FormaPagamentoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FormaPagamentoImpl implements FormaPagamentoRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<FormaPagamento> listarTodasFormaPagamento() {
        return manager.createQuery("from FormaPagamento", FormaPagamento.class).getResultList();
    }

    @Override
    public FormaPagamento buscarPorId(Long id) {
        return manager.find(FormaPagamento.class,id);
    }

    @Transactional
    @Override
    public FormaPagamento adicionar(FormaPagamento formaPagamento) {
        return manager.merge(formaPagamento);
    }

    @Transactional
    @Override
    public void remover(Long id) {
        FormaPagamento formaPagamento = buscarPorId(id);
        if(formaPagamento == null){
            throw  new EmptyResultDataAccessException(1);
        }
        manager.remove(formaPagamento);
    }
}
