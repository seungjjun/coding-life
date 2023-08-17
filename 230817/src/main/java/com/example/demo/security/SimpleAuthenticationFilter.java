package com.example.demo.security;

import org.springframework.http.HttpStatus;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SimpleAuthenticationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        RequestMatcher pathMatcher = new AntPathRequestMatcher("/user");

        if (pathMatcher.matches(request)) {
            try {
                String authorization = request.getHeader("Authorization");

                if (authorization == null) {
                    throw new RuntimeException();
                }
            } catch (RuntimeException e) {
                new FilterExceptionHandler(HttpStatus.BAD_REQUEST, "잘못된 요청입니다.").handleException(response);
            }
        }
    }
}
