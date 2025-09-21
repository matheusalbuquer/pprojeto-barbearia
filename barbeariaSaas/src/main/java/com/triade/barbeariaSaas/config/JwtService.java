package com.triade.barbeariaSaas.config;

import io.jsonwebtoken.Jwts;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component
public class JwtService {

    // Em produção, use chave forte (env/secret manager)
    private final SecretKey key = Jwts.SIG.HS256.key().build();

    public String generateToken(String username, long minutes) {
        Instant now = Instant.now();
        return Jwts.builder()
                .subject(username)
                .issuedAt(Date.from(now))
                .expiration(Date.from(now.plus(minutes, ChronoUnit.MINUTES)))
                .signWith(key)
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser().verifyWith(key).build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public boolean isValid(String token, UserDetails ud) {
        try {
            String sub = extractUsername(token);
            var claims = Jwts.parser().verifyWith(key).build()
                    .parseSignedClaims(token).getPayload();
            Date exp = claims.getExpiration();
            return ud.getUsername().equalsIgnoreCase(sub) && exp.after(new Date());
        } catch (Exception e) {
            return false;
        }
    }
}
