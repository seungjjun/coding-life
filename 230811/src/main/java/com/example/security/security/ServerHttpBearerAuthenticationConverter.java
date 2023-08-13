package com.example.security.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationConverter;

import javax.servlet.http.HttpServletRequest;

public class ServerHttpBearerAuthenticationConverter implements AuthenticationConverter {
    private static final String BEARER_PREFIX = "Bearer ";

    @Override
    public Authentication convert(HttpServletRequest request) {
        final String requestHeader = request.getHeader("Authorization");
        final String token = (requestHeader.length() <= BEARER_PREFIX.length()) ?
                "" :
                requestHeader.substring(BEARER_PREFIX.length());
        System.out.println("token : " + token);
        return UsernamePasswordAuthenticationToken.unauthenticated(token, token);
    }
}
