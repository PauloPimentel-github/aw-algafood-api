package com.phpimentel.awalgafoodapi.infra.repository;

import com.phpimentel.awalgafoodapi.domain.model.Cozinha;
import com.phpimentel.awalgafoodapi.domain.repository.CozinhaRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

public class CozinhaRepositoryImpl implements CozinhaRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Cozinha> listar() {
        return this.manager.createQuery("from Cozinha", Cozinha.class)
                .getResultList();
    }

    @Override
    public Cozinha buscar(Long id) {
        return this.manager.find(Cozinha.class, id);
    }

    @Transactional
    @Override
    public Cozinha salvar(Cozinha cozinha) {
        return this.manager.merge(cozinha);
    }

    @Transactional
    @Override
    public void remover(Cozinha cozinha) {
        cozinha = buscar(cozinha.getId());
        this.manager.remove(cozinha);
    }
}
