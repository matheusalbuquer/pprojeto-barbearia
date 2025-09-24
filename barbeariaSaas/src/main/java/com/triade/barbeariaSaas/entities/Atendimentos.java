package com.triade.barbeariaSaas.entities;

import com.triade.barbeariaSaas.enums.Procedimentos;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "atendimentos")
@Getter @Setter // opcional: gera o construtor com todos os campos
public class Atendimentos {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private LocalDateTime horarioAtendimento;

    @Enumerated(EnumType.STRING)
    private Procedimentos procedimentos;

    // lado DONO da relação com Barbearia
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "barbearia_id") // nome da FK na tabela de atendimentos
    private Barbearia barbearia;

    public Atendimentos(){}

    public Atendimentos(Long id, String titulo, LocalDateTime horarioAtendimento, Procedimentos procedimentos, Barbearia barbearia) {
        this.id = id;
        this.titulo = titulo;
        this.horarioAtendimento = horarioAtendimento;
        this.procedimentos = procedimentos;
        this.barbearia = barbearia;
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

    public LocalDateTime getHorarioAtendimento() {
        return horarioAtendimento;
    }

    public void setHorarioAtendimento(LocalDateTime horarioAtendimento) {
        this.horarioAtendimento = horarioAtendimento;
    }

    public Procedimentos getProcedimentos() {
        return procedimentos;
    }

    public void setProcedimentos(Procedimentos procedimentos) {
        this.procedimentos = procedimentos;
    }

    public Barbearia getBarbearia() {
        return barbearia;
    }

    public void setBarbearia(Barbearia barbearia) {
        this.barbearia = barbearia;
    }
}
