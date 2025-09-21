package com.triade.barbeariaSaas.repositories;

import com.triade.barbeariaSaas.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    // escolha um só padrão e use em todo o projeto:
    Admin findByEmail(String email);

    boolean existsByEmailIgnoreCase(String email);

    Optional<Admin> findByEmailIgnoreCase(String email);
}
