package com.triade.barbeariaSaas.repositories;

import com.triade.barbeariaSaas.entities.Atendimentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtendimentoRepository extends JpaRepository<Atendimentos, Long> {
}
