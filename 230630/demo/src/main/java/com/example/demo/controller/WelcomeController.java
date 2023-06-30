package com.example.demo.controller;

import com.example.demo.WebClientApp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class WelcomeController {
    private final WebClientApp webClientApp;

    public WelcomeController(WebClientApp webClientApp) {
        this.webClientApp = webClientApp;
    }

    @GetMapping(value = "/home")
    public Mono<String> welcome() {
        return webClientApp.getDataFromExternalService();
    }
}
