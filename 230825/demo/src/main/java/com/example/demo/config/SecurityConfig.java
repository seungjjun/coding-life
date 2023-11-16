package com.example.demo.config;

import com.example.demo.security.SimpleAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Order(1)
    @Bean
    public SecurityFilterChain userFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(request -> {
            request.requestMatchers(HttpMethod.GET, "/user").authenticated();
            request.anyRequest().permitAll();
                })
                .formLogin(AbstractHttpConfigurer::disable)
                .addFilterAt(new SimpleAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .sessionManagement(sessionManagement -> {
                    sessionManagement.sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
                    sessionManagement.sessionFixation().changeSessionId();
                });

        return httpSecurity.build();
    }

//    @Order(2)
//    @Bean
//    public SecurityFilterChain otherFilterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.authorizeHttpRequests(
//                request -> {
//                    request.requestMatchers(HttpMethod.GET, "/authenticated").permitAll();
//                })
//                .sessionManagement(sessionManagement -> {
//                    sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//                })
//                .cors(Customizer.withDefaults()).csrf(AbstractHttpConfigurer::disable);;
//        return httpSecurity.build();
//    }
}
