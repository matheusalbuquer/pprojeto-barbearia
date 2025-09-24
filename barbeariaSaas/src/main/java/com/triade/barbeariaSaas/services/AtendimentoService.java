package com.triade.barbeariaSaas.services;

import com.triade.barbeariaSaas.dtos.atendimentoDTO.AtendimentoResponse;
import com.triade.barbeariaSaas.dtos.atendimentoDTO.CriarAtendimentoDTO;
import com.triade.barbeariaSaas.entities.Atendimentos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AtendimentoService {

   AtendimentoResponse agendarAtendimento(CriarAtendimentoDTO dto);

   List<AtendimentoResponse> obterAtendimentos();

}
