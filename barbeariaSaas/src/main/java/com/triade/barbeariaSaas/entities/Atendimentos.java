package com.triade.barbeariaSaas.entities;

import com.triade.barbeariaSaas.enums.Procedimentos;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Atendimentos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titulo;

    private LocalDateTime tempoProcedimento;

    private Procedimentos procedimentos;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "admin_id", nullable = false)
    private Admin admin;

    // Se quiser guardar a barbearia diretamente no atendimento:
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "barbearia_id", nullable = false)
    private Barbearia barbearia;


    public Atendimentos (){}


    public Atendimentos(Long id, String titulo, LocalDateTime tempoProcedimento, Procedimentos procedimentos) {
        this.id = id;
        this.titulo = titulo;
        this.tempoProcedimento = tempoProcedimento;
        this.procedimentos = procedimentos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDateTime getTempoProcedimento() {
        return tempoProcedimento;
    }

    public void setTempoProcedimento(LocalDateTime tempoProcedimento) {
        this.tempoProcedimento = tempoProcedimento;
    }

    public Procedimentos getProcedimentos() {
        return procedimentos;
    }

    public void setProcedimentos(Procedimentos procedimentos) {
        this.procedimentos = procedimentos;
    }
}
