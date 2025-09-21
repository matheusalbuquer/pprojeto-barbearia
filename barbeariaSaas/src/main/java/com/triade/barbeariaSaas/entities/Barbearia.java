package com.triade.barbeariaSaas.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Barbearia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private String cpfoucnpj;

    private String telefone;

    @OneToMany(mappedBy = "barbearia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Admin> admins = new ArrayList<>();

    @OneToMany(mappedBy = "barbearia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Atendimentos> atendimentos = new ArrayList<>();

    public Barbearia (){}

    public Barbearia(String nome, String cpfoucnpj, String telefone) {
        this.nome = nome;
        this.cpfoucnpj = cpfoucnpj;
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }



}
