package com.triade.barbeariaSaas.repositories;

import com.triade.barbeariaSaas.entities.Admin;
import com.triade.barbeariaSaas.entities.Barbearia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BarbeariaRepository extends JpaRepository<Barbearia, Long> {
    Barbearia findBycpfoucnpj(String cpfoucnpj);

    Barbearia findByNome(String nome);

    boolean existsByCpfoucnpj(String cpfoucnpj);        // ✅ use isso p/ checar duplicidade
    Optional<Barbearia> findByCpfoucnpj(String cpfoucnpj); // (s
}
