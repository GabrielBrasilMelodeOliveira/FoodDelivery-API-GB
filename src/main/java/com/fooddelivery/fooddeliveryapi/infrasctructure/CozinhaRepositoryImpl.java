package com.fooddelivery.fooddeliveryapi.infrasctructure;

import com.fooddelivery.fooddeliveryapi.domain.model.Cozinha;
import com.fooddelivery.fooddeliveryapi.domain.repository.CozinhaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CozinhaRepositoryImpl implements CozinhaRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Cozinha> listarTodasCozinhas(){
        return manager.createQuery("from Cozinha", Cozinha.class).getResultList();
    }
    @Override
    public Cozinha buscarPorId(Long id){
        return manager.find(Cozinha.class,id);
    }
    @Override
    @Transactional
    public Cozinha adicionar(Cozinha cozinha){
        return manager.merge(cozinha);
    }

    @Override
    @Transactional
    public void remover(Cozinha cozinha){
        cozinha = buscarPorId(cozinha.getId());
        manager.remove(cozinha);
    }
}
