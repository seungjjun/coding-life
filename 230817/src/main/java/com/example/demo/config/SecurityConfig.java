package com.example.demo.config;

import com.example.demo.security.SimpleAuthenticationFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/user")
            .authenticated()
            .and()
            .authorizeRequests()
            .anyRequest()
            .permitAll()
            .and()
            .addFilterAt(new SimpleAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
