package com.triade.barbeariaSaas.services.impl;

import com.triade.barbeariaSaas.dtos.atendimentoDTO.AtendimentoResponse;
import com.triade.barbeariaSaas.dtos.atendimentoDTO.CriarAtendimentoDTO;
import com.triade.barbeariaSaas.entities.Admin;
import com.triade.barbeariaSaas.entities.Atendimentos;
import com.triade.barbeariaSaas.entities.Barbearia;
import com.triade.barbeariaSaas.repositories.AdminRepository;
import com.triade.barbeariaSaas.repositories.AtendimentoRepository;
import com.triade.barbeariaSaas.services.AtendimentoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AtendimentoServiceImpl implements AtendimentoService {

    private final AtendimentoRepository atendimentoRepository;
    private final AdminRepository adminRepository;

    @Override
    @Transactional
    public AtendimentoResponse agendarAtendimento(CriarAtendimentoDTO dto) {
        // 1) Pega o admin logado
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        Admin admin = adminRepository.findByEmailIgnoreCase(email)
                .orElseThrow(() -> new IllegalStateException("Admin não encontrado para o usuário logado"));

        // 2) Barbearia vem do admin logado (nunca confie em id no payload)
        Barbearia barbearia = admin.getBarbearia();
        if (barbearia == null) {
            throw new IllegalStateException("Admin não está vinculado a nenhuma barbearia");
        }

        // 3) Monta a entidade (use SEMPRE o objeto Barbearia, não o Long id)
        Atendimentos atendimentos = new Atendimentos();
        atendimentos.setTitulo(dto.titulo());
        atendimentos.setHorarioAtendimento(dto.horarioAtendimento());
        atendimentos.setProcedimentos(dto.procedimentos());
        atendimentos.setBarbearia(barbearia);

        // (Opcional) Se sua entidade tiver campo Admin criador/responsável:
        // atendimentos.setAdmin(admin);

        // 4) Persiste
        Atendimentos salvo = atendimentoRepository.save(atendimentos);

        // 5) Retorna o Response usando os dados DA ENTIDADE SALVA
        // (Assinatura típica do record: (Long id, String titulo, LocalDateTime horario, Procedimentos proc, Long barbeariaId))
        return new AtendimentoResponse(
                salvo.getId(),
                salvo.getTitulo(),
                salvo.getProcedimentos(),
                salvo.getHorarioAtendimento(),
                salvo.getBarbearia().getId()
        );
    }

    @Override
    public List<AtendimentoResponse> obterAtendimentos(){

        List<Atendimentos> entidades = atendimentoRepository.findAll();

        return  entidades.stream()
                .map(a -> new AtendimentoResponse(
                a.getId(),
                a.getTitulo(),
                a.getProcedimentos(),
                a.getHorarioAtendimento(),
                null
        ))
       .toList();
    }





}
