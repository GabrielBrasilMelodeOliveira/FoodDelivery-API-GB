package com.fooddelivery.fooddeliveryapi.infrasctructure;

import com.fooddelivery.fooddeliveryapi.domain.model.Restaurante;
import com.fooddelivery.fooddeliveryapi.domain.repository.RestauranteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RestauranteRepositoryImpl implements RestauranteRepository {
    @PersistenceContext
    EntityManager manager;

    @Override
    public List<Restaurante> listar() {
        return manager.createQuery("from Restaurante", Restaurante.class).getResultList();
    }

    @Override
    public Restaurante buscarPorId(Long id) {
        return manager.find(Restaurante.class,id);
    }

    @Transactional
    @Override
    public Restaurante adicionar(Restaurante restaurante) {
        return manager.merge(restaurante);
    }

    @Transactional
    @Override
    public void remover(Restaurante restaurante) {
        restaurante = buscarPorId(restaurante.getId());
        manager.remove(restaurante);
    }
}
