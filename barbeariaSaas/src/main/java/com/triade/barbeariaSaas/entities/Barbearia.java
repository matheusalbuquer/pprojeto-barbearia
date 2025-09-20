package com.triade.barbeariaSaas.entities;

import jakarta.persistence.*;

@Entity
public class Barbearia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private String telefone;

    @OneToMany
    private Admin admin;
}
