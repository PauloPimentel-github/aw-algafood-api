package com.phpimentel.awalgafoodapi.infra.repository;

import com.phpimentel.awalgafoodapi.domain.model.Permissao;
import com.phpimentel.awalgafoodapi.domain.repository.PermissaoRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class PermissaoRepositoryImpl implements PermissaoRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Permissao> listar() {
        return this.manager.createQuery("from Permissao", Permissao.class)
                .getResultList();
    }

    @Override
    public Permissao buscar(Long id) {
        return this.manager.find(Permissao.class, id);
    }

    @Transactional
    @Override
    public Permissao salvar(Permissao permissao) {
        return this.manager.merge(permissao);
    }

    @Transactional
    @Override
    public void remover(Permissao permissao) {
        permissao = buscar(permissao.getId());
        this.manager.remove(permissao);
    }
}
