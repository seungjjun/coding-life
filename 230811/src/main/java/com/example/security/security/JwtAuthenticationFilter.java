package com.example.security.security;

import com.example.security.utils.JWtTokenUtil;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.security.web.util.matcher.RequestMatcher;

public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private static final String BEARER_PREFIX = "Bearer ";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        RequestMatcher pathMatcher = new AntPathRequestMatcher("/user/hello");
        if (pathMatcher.matches(request)) {
            final String requestHeader = request.getHeader("Authorization");
            String authToken = requestHeader.replace(BEARER_PREFIX,"");

            String username = JWtTokenUtil.getUsernameFromToken(authToken);

            System.out.println(username);
//            UsernamePasswordAuthenticationToken.unauthenticated(token, token);
        }


        filterChain.doFilter(request, response);
    }
}

/*
String header = req.getHeader(HEADER_STRING);
        String username = null;
        String authToken = null;

        if (header != null && header.startsWith(TOKEN_PREFIX)) {
            authToken = header.replace(TOKEN_PREFIX,"");
            // Extract user information from token using a helper method or library
            username = JwtTokenUtil.getUsernameFromToken(authToken);
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            // Assuming a service exists to load user details
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            if (JwtTokenUtil.validateToken(authToken, userDetails)) { // Implement this function in your JWT utility class
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        chain.doFilter(req, res);
    }
 */
