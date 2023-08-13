package com.example.security.controller;

import com.example.security.service.JwtTokenGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
public class JwtTokenController {
    private final JwtTokenGenerator jwtTokenGenerator;

    public JwtTokenController(JwtTokenGenerator jwtTokenGenerator) {
        this.jwtTokenGenerator = jwtTokenGenerator;
    }

    @GetMapping
    public String generateJwtToken() {
        return jwtTokenGenerator.generateToken("id");
    }
}
