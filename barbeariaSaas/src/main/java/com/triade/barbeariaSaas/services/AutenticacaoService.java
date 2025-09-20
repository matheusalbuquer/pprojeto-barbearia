package com.triade.barbeariaSaas.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.nimbusds.jose.Algorithm;
import com.triade.barbeariaSaas.entities.Admin;
import com.triade.barbeariaSaas.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;


import java.util.Date;

@Service
public class AutenticacaoService {

    @Autowired
    private AdminRepository adminRepository;

    private static final String SECRET = "minha_chave_secreta"; // coloque em variáveis de ambiente
    private static final long EXPIRATION_TIME = 1000 * 60 * 60; //


    public UserDetails loadUserByUsername (String email) throws UsernameNotFoundException {
        Admin usuario = adminRepository.findByLogin(email);

        if (usuario == null){
            throw new UsernameNotFoundException("Usuario não encontrado");
        }
        return usuario;
    }

    public String gerarToken(Admin admin) {
        try {
            Algorithm algorithm = Algorithm.(SECRET);

            return JWT.create()
                    .withIssuer("sistema-odontologia") // quem gerou o token
                    .withSubject(admin.getEmail())     // identificador do usuário
                    .withClaim("role", "ADMIN")        // pode colocar permissões ou ID
                    .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                    .sign(algorithm);

        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro ao gerar token JWT", exception);
        }
    }


}