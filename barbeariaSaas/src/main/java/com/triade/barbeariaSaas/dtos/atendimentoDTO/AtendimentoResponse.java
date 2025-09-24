package com.triade.barbeariaSaas.dtos.atendimentoDTO;

import com.triade.barbeariaSaas.enums.Procedimentos;
import java.time.LocalDateTime;

public record AtendimentoResponse(
        Long id,
        String titulo,
        Procedimentos procedimentos,
        LocalDateTime horarioAtendimento,
        Long barbeariaId
) {}
