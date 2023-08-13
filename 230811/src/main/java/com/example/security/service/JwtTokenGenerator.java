package com.example.security.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtTokenGenerator {
    private static final long EXPIRATION_TIME = 864_000_000; // 10 days
    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String generateToken(String userId) {
        Date issuedAt = new Date();
        Date expiresAt = new Date(issuedAt.getTime() + EXPIRATION_TIME);

        return Jwts.builder()
                .setSubject(userId)
                .setIssuedAt(issuedAt)
                .setExpiration(expiresAt)
                .signWith(key)
                .compact();
    }
}
