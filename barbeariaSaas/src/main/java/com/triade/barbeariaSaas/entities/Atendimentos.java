package com.triade.barbeariaSaas.entities;

import com.triade.barbeariaSaas.enums.Procedimentos;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Atendimentos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titulo;

    private LocalDateTime tempoProcedimento;

    private Procedimentos procedimentos;
}
