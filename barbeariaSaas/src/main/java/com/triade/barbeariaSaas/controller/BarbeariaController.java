package com.triade.barbeariaSaas.controller;

import com.triade.barbeariaSaas.dtos.barberiaDTO.BarbeariaDTO;
import com.triade.barbeariaSaas.entities.Barbearia;
import com.triade.barbeariaSaas.repositories.BarbeariaRepository;
import com.triade.barbeariaSaas.services.BarbeariaService;
import com.triade.barbeariaSaas.services.impl.BarbeariaServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/barbearia")
@RequiredArgsConstructor
public class BarbeariaController {

    private final BarbeariaService barbeariaService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Map<String, Object>> cadastrarBarbearia(@Valid @RequestBody BarbeariaDTO dto) {
        BarbeariaDTO criada = barbeariaService.cadastrarBarbearia(dto); // <- NUNCA deve ser null
        return ResponseEntity.ok(Map.of(
                "mensagem", "Barbearia criada com sucesso",
                "nome_clinica", criada.nome()
        ));
    }
}
