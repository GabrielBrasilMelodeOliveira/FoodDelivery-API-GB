package com.fooddelivery.fooddeliveryapi.infrasctructure;

import com.fooddelivery.fooddeliveryapi.domain.model.Permissao;
import com.fooddelivery.fooddeliveryapi.domain.repository.PermissaoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PermissaoRepositoryImpl implements PermissaoRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Permissao> listarTodasPermissao() {
        return manager.createQuery("from Permissao",Permissao.class).getResultList();
    }

    @Override
    public Permissao buscarPorId(Long id) {
        return manager.find(Permissao.class,id);
    }

    @Transactional
    @Override
    public Permissao adicionar(Permissao permissao) {
        return manager.merge(permissao);
    }

    @Transactional
    @Override
    public void remover(Permissao permissao) {
        permissao = buscarPorId(permissao.getId());
        manager.remove(permissao);
    }
}
