package com.phpimentel.awalgafoodapi.domain.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "cozinhas")
public class Cozinha {

    @Id
    private Long id;

    @Column(name = "nome")
    private String nome;
}
