package com.example.security.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class JWtTokenUtil {
    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public static String getUsernameFromToken(String token) {
        Claims jws = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return jws.getSubject();
    }
}
