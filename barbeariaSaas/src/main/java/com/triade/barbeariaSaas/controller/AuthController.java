package com.triade.barbeariaSaas.controller;

import com.triade.barbeariaSaas.config.JwtService;
import com.triade.barbeariaSaas.dtos.authDTO.LoginRequest;
import com.triade.barbeariaSaas.dtos.authDTO.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest req) {
        var auth = new UsernamePasswordAuthenticationToken(req.email(), req.senha());
        authManager.authenticate(auth); // lança se inválido
        String token = jwtService.generateToken(req.email(), 120); // 120 min
        return ResponseEntity.ok(new TokenResponse(token, "Bearer"));
    }

    @GetMapping("/me")
    public ResponseEntity<Map<String, Object>> me(Authentication authentication) {
        var principal = authentication.getName(); // email
        return ResponseEntity.ok(Map.of("email", principal));
    }
}
