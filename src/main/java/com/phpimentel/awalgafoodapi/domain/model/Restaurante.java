package com.phpimentel.awalgafoodapi.domain.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "restaurantes")
public class Restaurante {

    @Id
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "taxa_frete")
    private BigDecimal taxaFrete;
}
