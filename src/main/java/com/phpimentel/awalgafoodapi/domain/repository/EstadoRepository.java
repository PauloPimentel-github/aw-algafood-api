package com.phpimentel.awalgafoodapi.domain.repository;

import com.phpimentel.awalgafoodapi.domain.model.Estado;

import java.util.List;

public interface EstadoRepository {

    List<Estado> listar();
    Estado buscar(Long id);
    Estado salvar(Estado estado);
    void remover(Estado estado);
}
