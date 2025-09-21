package com.triade.barbeariaSaas.services.impl;

import com.triade.barbeariaSaas.entities.Admin;
import com.triade.barbeariaSaas.repositories.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminUserDetailsService implements UserDetailsService {

    private final AdminRepository repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Admin a = repo.findByEmailIgnoreCase(email)
                .orElseThrow(() -> new UsernameNotFoundException("Admin não encontrado"));
        return User.builder()
                .username(a.getEmail())
                .password(a.getSenhaHash())
                .roles("ADMIN") // ajuste se tiver tabela de perfis
                .build();
    }
}