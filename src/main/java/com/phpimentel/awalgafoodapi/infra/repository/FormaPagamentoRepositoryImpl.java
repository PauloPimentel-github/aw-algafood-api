package com.phpimentel.awalgafoodapi.infra.repository;

import com.phpimentel.awalgafoodapi.domain.model.FormaPagamento;
import com.phpimentel.awalgafoodapi.domain.repository.FormaPagamentoRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class FormaPagamentoRepositoryImpl implements FormaPagamentoRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<FormaPagamento> listar() {
        return this.manager.createQuery("from FormaPagamento", FormaPagamento.class)
                .getResultList();
    }

    @Override
    public FormaPagamento buscar(Long id) {
        return this.manager.find(FormaPagamento.class, id);
    }

    @Transactional
    @Override
    public FormaPagamento salvar(FormaPagamento formaPagamento) {
        return manager.merge(formaPagamento);
    }

    @Transactional
    @Override
    public void remover(FormaPagamento formaPagamento) {
        formaPagamento = buscar(formaPagamento.getId());
        this.manager.remove(formaPagamento);
    }
}
