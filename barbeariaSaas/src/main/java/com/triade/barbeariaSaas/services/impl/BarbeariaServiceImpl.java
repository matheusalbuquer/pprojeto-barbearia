package com.triade.barbeariaSaas.services.impl;

import com.triade.barbeariaSaas.dtos.barberiaDTO.BarbeariaDTO;
import com.triade.barbeariaSaas.entities.Barbearia;
import com.triade.barbeariaSaas.repositories.BarbeariaRepository;
import com.triade.barbeariaSaas.services.BarbeariaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BarbeariaServiceImpl implements BarbeariaService {

    @Autowired
    private BarbeariaRepository barbeariaRepository;


    @Override
    @Transactional
    public BarbeariaDTO cadastrarBarbearia(BarbeariaDTO dto) {
        String doc = dto.cpfoucnpj() == null ? "" : dto.cpfoucnpj().trim();
        if (doc.isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CPF/CNPJ é obrigatório");
        if (barbeariaRepository.existsByCpfoucnpj(doc)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "CPF/CNPJ já cadastrado");
        }

        Barbearia e = new Barbearia();
        e.setNome(dto.nome());
        e.setTelefone(dto.telefone());
        e.setCpfoucnpj(doc);

        Barbearia salvo = barbeariaRepository.save(e);

        // 🔴 AQUI estava o problema: antes você retornava null
        return new BarbeariaDTO(salvo.getNome(), salvo.getTelefone(), salvo.getCpfoucnpj());
    }

}
