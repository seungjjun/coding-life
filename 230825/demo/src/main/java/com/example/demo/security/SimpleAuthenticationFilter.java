package com.example.demo.security;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class SimpleAuthenticationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        RequestMatcher pathMatcher = new AntPathRequestMatcher("/user");

        if (pathMatcher.matches(request)) {
            try {
                Authentication authentication = new UsernamePasswordAuthenticationToken("name", null, List.of());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } catch (RuntimeException e) {
                new Exception();
            }
        }

        filterChain.doFilter(request, response);

    }
}