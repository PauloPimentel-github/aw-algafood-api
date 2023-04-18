package com.phpimentel.awalgafoodapi.infra.repository;

import com.phpimentel.awalgafoodapi.domain.model.Cidade;
import com.phpimentel.awalgafoodapi.domain.repository.CidadeRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class CidadeRepositoryImpl implements CidadeRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Cidade> listar() {
        return this.manager.createQuery("from Cidade", Cidade.class)
                .getResultList();
    }

    @Override
    public Cidade buscar(Long id) {
        return this.manager.find(Cidade.class, id);
    }

    @Transactional
    @Override
    public Cidade salvar(Cidade cidade) {
        return this.manager.merge(cidade);
    }

    @Transactional
    @Override
    public void remover(Cidade cidade) {
        cidade = buscar(cidade.getId());
        this.manager.remove(cidade);
    }
}
