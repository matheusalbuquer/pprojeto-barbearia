package com.triade.barbeariaSaas.dtos.cadastro;

public record CriarBarbeariaComAdminResponseDTO(Long barbeariaId,
                                                String nomeBarbearia,
                                                String cpfoucnpj,
                                                Long adminId,
                                                String nomeAdmin,
                                                String emailAdmin
) {
}
