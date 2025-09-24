package com.triade.barbeariaSaas.dtos.atendimentoDTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.triade.barbeariaSaas.enums.Procedimentos;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public record CriarAtendimentoDTO(

        Long idDoAtendimento,
        String titulo,


        @Future // opcional, se quiser obrigar data futura
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime horarioAtendimento,

        Procedimentos procedimentos,

          Long barbeariaId
) {}
