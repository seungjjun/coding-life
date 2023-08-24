package com.example.demo.config;

import com.example.demo.security.SimpleAuthenticationFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.requestMatchers(request ->
                request.antMatchers(HttpMethod.GET, "/user"))
            .addFilterAt(new SimpleAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
            .sessionFixation().changeSessionId()
            .and()
                .cors(Customizer.withDefaults()).csrf(AbstractHttpConfigurer::disable)
                .authorizeRequests().anyRequest().permitAll()
            .and()
                .addFilterAt(new SimpleAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
