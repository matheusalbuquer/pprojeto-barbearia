package com.triade.barbeariaSaas.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Admin {

    @Id
    private Long id;

    private String nome;

    private String email;

    private String senha;

    @ManyToOne
    private Barbearia barbearia;

    public Admin(Long id, String nome, String email, String senha, Barbearia barbearia) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.barbearia = barbearia;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Barbearia getBarbearia() {
        return barbearia;
    }

    public void setBarbearia(Barbearia barbearia) {
        this.barbearia = barbearia;
    }
}
