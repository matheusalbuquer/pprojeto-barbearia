package com.triade.barbeariaSaas.repositories;

import com.triade.barbeariaSaas.dtos.atendimentoDTO.AtendimentoResponse;
import com.triade.barbeariaSaas.entities.Atendimentos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AtendimentoRepository extends JpaRepository<Atendimentos, Long> {
;
}
