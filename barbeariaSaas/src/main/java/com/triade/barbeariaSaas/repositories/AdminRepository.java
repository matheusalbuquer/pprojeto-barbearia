package com.triade.barbeariaSaas.repositories;

import com.triade.barbeariaSaas.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    Admin findByLogin(String email);
}
