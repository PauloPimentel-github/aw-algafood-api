package com.phpimentel.awalgafoodapi.domain.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cozinhas")
public class Cozinha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;
}
