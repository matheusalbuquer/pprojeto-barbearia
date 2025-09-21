package com.triade.barbeariaSaas.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;




@Entity
@Table(name = "admin")
@AllArgsConstructor
@Getter
@Setter
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    private String email;

    @Column(name = "senha_hash", nullable = false, length = 100)
    private String senhaHash; // <-- campo que combina com setSenhaHash


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "barbearia_id", nullable = false)
    private Barbearia barbearia;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Atendimentos> atendimentos = new ArrayList<>();

    public Admin() {
    }

    public Admin(Long id, String nome, String email, String senhaHash, Barbearia barbearia) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senhaHash = senhaHash;
        this.barbearia = barbearia;
    }




}
