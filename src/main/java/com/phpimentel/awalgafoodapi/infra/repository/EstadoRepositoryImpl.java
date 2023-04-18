package com.phpimentel.awalgafoodapi.infra.repository;

import com.phpimentel.awalgafoodapi.domain.model.Estado;
import com.phpimentel.awalgafoodapi.domain.repository.EstadoRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class EstadoRepositoryImpl implements EstadoRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Estado> listar() {
        return this.manager.createQuery("from Estado", Estado.class)
                .getResultList();
    }

    @Override
    public Estado buscar(Long id) {
        return this.manager.find(Estado.class, id);
    }

    @Transactional
    @Override
    public Estado salvar(Estado estado) {
        return this.manager.merge(estado);
    }

    @Transactional
    @Override
    public void remover(Estado estado) {
        estado = buscar(estado.getId());
        this.manager.remove(estado);
    }
}
