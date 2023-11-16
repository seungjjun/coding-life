package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class WebClientApp {

    @Autowired
    private WebClient.Builder webClientBuilder;

    public Mono<String> getDataFromExternalService() {
        return webClientBuilder.build()
                .get()
                .uri("https://jsonplaceholder.typicode.com/todos/1")
                .retrieve()
                .bodyToMono(String.class);
    }
}
