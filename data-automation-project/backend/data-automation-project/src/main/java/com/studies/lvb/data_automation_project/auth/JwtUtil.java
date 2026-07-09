package com.studies.lvb.data_automation_project.auth;

import com.studies.lvb.data_automation_project.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtil {

    private final JwtConfig jwtConfig;
    private final SecretKey secretKey;

    public JwtUtil(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
        this.secretKey = Keys.hmacShaKeyFor(jwtConfig.getSecret().getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(final User user) {
        final Claims claims = Jwts.claims()
                .add("firstName", user.getFirstName())
                .add("lastName", user.getLastName())
                .subject(user.getEmail())
                .build();

        final Date now = new Date();
        final Date expirationDate = new Date(now.getTime() + jwtConfig.getExpiration());

        return Jwts.builder()
                .claims(claims)
                .issuedAt(now)
                .expiration(expirationDate)
                .signWith(secretKey)
                .compact();
    }

    public String generateRefreshToken(final String email) {
        final Claims claims = Jwts.claims().subject(email).build();
        final Date now = new Date();
        final Date expirationDate = new Date(now.getTime() + jwtConfig.getRefreshTokenExpiration());

        return Jwts.builder()
                .claims(claims)
                .issuedAt(now)
                .expiration(expirationDate)
                .signWith(secretKey)
                .compact();
    }

    public boolean validateToken(final String token) {
        try {
            final Date expiration = Jwts.parser()
                    .verifyWith(secretKey)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload().getExpiration();

            return expiration.after(new Date());
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    public String getUsernameFromToken(String token) {
        String subject = Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();

        //TODO adicionar excecao custom depois
        if (subject == null || subject.isBlank()) {
            throw new IllegalArgumentException("Token sem subject (username)");
        }

        return subject;
    }
}
