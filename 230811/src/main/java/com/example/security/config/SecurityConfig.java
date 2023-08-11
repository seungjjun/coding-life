package com.example.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain defaultFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
                                .requestMatchers("/user/**")
                                .permitAll().anyRequest())
                .securityContext((securityContext) -> securityContext.disable())
                .sessionManagement((sessionManagement) -> sessionManagement.disable())
                .build();
    }

    @Bean
    public SecurityFilterChain authorizationFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
                        .anyRequest().authenticated()).build();
    }
}
