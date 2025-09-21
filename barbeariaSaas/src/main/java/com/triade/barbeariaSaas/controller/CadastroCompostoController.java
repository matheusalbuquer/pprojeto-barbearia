package com.triade.barbeariaSaas.controller;

import com.triade.barbeariaSaas.dtos.cadastro.CriarBarbeariaComAdminDTO;
import com.triade.barbeariaSaas.dtos.cadastro.CriarBarbeariaComAdminResponseDTO;
import com.triade.barbeariaSaas.services.CadastroCompostoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/cadastros")
@RequiredArgsConstructor
public class CadastroCompostoController {

    private final CadastroCompostoService cadastroCompostoService;

    @PostMapping("/barbearia-com-admin")
    public ResponseEntity<CriarBarbeariaComAdminResponseDTO> criar(@Valid @RequestBody CriarBarbeariaComAdminDTO dto) {
        var resp = cadastroCompostoService.cadastrarBarbeariaComAdmin(dto);
        // Created 201 com Location apontando para a barbearia criada
        return ResponseEntity
                .created(URI.create("/barbearias/" + resp.barbeariaId()))
                .body(resp);
    }
}

