package com.example.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authenticated")
public class AuthenticatedController {
    @GetMapping
    private String authenticated(HttpServletRequest request) {
        System.out.println("authenticated!!");
        System.out.println(request.getSession().getId());
        System.out.println(request.getSession());
        return "authenticated!";
    }
}
