package com.triade.barbeariaSaas.dtos.cadastro;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CriarBarbeariaComAdminDTO(
        // barbearia
        @NotBlank @Size(max = 120) String nomeBarbearia,
        @NotBlank @Size(max = 20)  String telefoneBarbearia,
        @NotBlank @Size(max = 20)  String cpfoucnpj,

        // admin
        @NotBlank @Size(max = 120) String nomeAdmin,
        @NotBlank @Email @Size(max = 160) String emailAdmin,
        @NotBlank @Size(min = 6, max = 72) String senhaAdmin
) {
}
