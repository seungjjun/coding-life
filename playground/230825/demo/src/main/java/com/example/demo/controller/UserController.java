package com.example.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping
    public ResponseEntity<String> user(HttpServletRequest request) {
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
        System.out.println(request.getSession().getId());
        System.out.println(request.getSession());
        return ResponseEntity.ok("Hello!");
    }
}
