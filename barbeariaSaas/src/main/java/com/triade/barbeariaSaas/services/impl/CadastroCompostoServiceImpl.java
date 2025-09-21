package com.triade.barbeariaSaas.services.impl;

import com.triade.barbeariaSaas.dtos.cadastro.CriarBarbeariaComAdminDTO;
import com.triade.barbeariaSaas.dtos.cadastro.CriarBarbeariaComAdminResponseDTO;
import com.triade.barbeariaSaas.entities.Admin;
import com.triade.barbeariaSaas.entities.Barbearia;
import com.triade.barbeariaSaas.repositories.AdminRepository;
import com.triade.barbeariaSaas.repositories.BarbeariaRepository;
import com.triade.barbeariaSaas.services.CadastroCompostoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class CadastroCompostoServiceImpl implements CadastroCompostoService {

    private final BarbeariaRepository barbeariaRepository;
    private final AdminRepository adminRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public CriarBarbeariaComAdminResponseDTO cadastrarBarbeariaComAdmin(CriarBarbeariaComAdminDTO dto) {

        String doc = dto.cpfoucnpj().trim();
        String email = dto.emailAdmin().trim();

        // validações de unicidade ANTES
        if (barbeariaRepository.existsByCpfoucnpj(doc)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "CPF/CNPJ já cadastrado");
        }
        if (adminRepository.existsByEmailIgnoreCase(email)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "E-mail do admin já cadastrado");
        }

        // cria a barbearia
        Barbearia b = new Barbearia();
        b.setNome(dto.nomeBarbearia().trim());
        b.setTelefone(dto.telefoneBarbearia().trim());
        b.setCpfoucnpj(doc);
        Barbearia bSalva = barbeariaRepository.save(b);

        // cria o admin vinculado
        Admin a = new Admin();
        a.setNome(dto.nomeAdmin().trim());
        a.setEmail(email);
        a.setSenhaHash(passwordEncoder.encode(dto.senhaAdmin()));
        a.setBarbearia(bSalva);
        Admin aSalvo = adminRepository.save(a);

        return new CriarBarbeariaComAdminResponseDTO(
                bSalva.getId(),
                bSalva.getNome(),
                bSalva.getCpfoucnpj(),
                aSalvo.getId(),
                aSalvo.getNome(),
                aSalvo.getEmail()
        );
    }
}