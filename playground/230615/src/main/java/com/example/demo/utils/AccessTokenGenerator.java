package com.example.demo.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Component
public class AccessTokenGenerator {
    private final Algorithm algorithm;

    public AccessTokenGenerator(
        @Value("${jwt.secret}") String secret
    ) {
        this.algorithm = Algorithm.HMAC256(secret);
    }

    public String generate(String userId) {
        return JWT.create()
            .withClaim("userId", userId)
            .withExpiresAt(Instant.now().plus(24, ChronoUnit.HOURS))
            .sign(algorithm);
    }

    public boolean verify(String accessToken) {
        try {
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT verify = verifier.verify(accessToken);

            String userId = verify.getClaim("userId").asString();

            return true;
        } catch (JWTVerificationException e) {
            return false;
        }
    }
}