package com.fooddelivery.fooddeliveryapi.infrasctructure;

import com.fooddelivery.fooddeliveryapi.domain.model.Cidade;
import com.fooddelivery.fooddeliveryapi.domain.repository.CidadeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CidadeRepositoryImpl implements CidadeRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Cidade> listarTodasCidade() {
        return manager.createQuery("from Cidade", Cidade.class).getResultList();
    }

    @Override
    public Cidade buscarPorId(Long id) {
        return manager.find(Cidade.class,id);
    }

    @Transactional
    @Override
    public Cidade adicionar(Cidade cidade) {
        return manager.merge(cidade);
    }

    @Override
    public void remover(Cidade cidade) {
        cidade = buscarPorId(cidade.getId());
        manager.remove(cidade);
    }
}
