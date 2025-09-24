package com.triade.barbeariaSaas.controller;

import com.triade.barbeariaSaas.dtos.atendimentoDTO.CriarAtendimentoDTO;
import com.triade.barbeariaSaas.dtos.atendimentoDTO.AtendimentoResponse;
import com.triade.barbeariaSaas.entities.Atendimentos;
import com.triade.barbeariaSaas.enums.Procedimentos;
import com.triade.barbeariaSaas.services.AtendimentoService;
import com.triade.barbeariaSaas.services.impl.AtendimentoServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/atendimentos")
@RequiredArgsConstructor
public class AtendimentoController {

    private final AtendimentoService atendimentoService;

    @PostMapping
    public ResponseEntity<AtendimentoResponse> agendarAtendimento (@RequestBody CriarAtendimentoDTO dto){
        AtendimentoResponse atendimentos = atendimentoService.agendarAtendimento(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(atendimentos);
    }

    @GetMapping
    public ResponseEntity<List<AtendimentoResponse>> obterAtendimentos() {
        List<AtendimentoResponse> atendimentos = atendimentoService.obterAtendimentos();
        return ResponseEntity.ok(atendimentos);
    }

}
