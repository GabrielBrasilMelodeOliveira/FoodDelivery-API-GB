package com.fooddelivery.fooddeliveryapi.infrasctructure;

import com.fooddelivery.fooddeliveryapi.domain.model.Estado;
import com.fooddelivery.fooddeliveryapi.domain.repository.EstadoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EstadoRepositoryImpl implements EstadoRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Estado> listarTodosEstados() {
        return manager.createQuery("from Estado", Estado.class).getResultList();
    }

    @Override
    public Estado buscarPorId(Long id) {
        return manager.find(Estado.class,id);
    }

    @Transactional
    @Override
    public Estado adicionar(Estado estado) {
        return manager.merge(estado);
    }

    @Transactional
    @Override
    public void remover(Long id) {
        Estado estado = buscarPorId(id);
        if(estado == null){
            throw  new EmptyResultDataAccessException(1);
        }
        manager.remove(estado);
    }
}
