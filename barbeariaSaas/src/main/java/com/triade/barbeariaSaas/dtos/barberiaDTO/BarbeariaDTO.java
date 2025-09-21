package com.triade.barbeariaSaas.dtos.barberiaDTO;

import jakarta.validation.constraints.NotBlank;

public record BarbeariaDTO(
        @NotBlank String nome,
        @NotBlank
        String cpfoucnpj,
        @NotBlank
        String telefone) {
}
