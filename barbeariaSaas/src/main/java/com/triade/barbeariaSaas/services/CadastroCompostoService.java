package com.triade.barbeariaSaas.services;

import com.triade.barbeariaSaas.dtos.cadastro.CriarBarbeariaComAdminDTO;
import com.triade.barbeariaSaas.dtos.cadastro.CriarBarbeariaComAdminResponseDTO;

public interface CadastroCompostoService {

    CriarBarbeariaComAdminResponseDTO cadastrarBarbeariaComAdmin(CriarBarbeariaComAdminDTO dto);
}
