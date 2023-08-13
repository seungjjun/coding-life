package com.example.security.config;

import com.example.security.security.JwtAuthenticationFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Order(1)
    @Configuration
    public static class TokenSecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    .antMatchers("/user/hello")
                    .authenticated()
                    .anyRequest()
                    .permitAll()
                    .and()
                    .addFilterAt(new JwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        }
    }

    @Order(2)
    @Configuration
    public static class SessionSecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    .antMatchers("/token")
                    .permitAll()
                    .anyRequest()
                    .authenticated();
        }
    }
}

//             AuthenticationConverter authenticationConverter = new ServerHttpBearerAuthenticationConverter();
