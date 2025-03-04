package com.example.demo.security;

import com.example.demo.CommonBean;
import com.example.demo.SampleA;
import com.example.demo.SampleB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = true)
public class CustomConfiguration {
    @Bean
    public CommonBean commonBean() {
        return new CommonBean();
    }

    @Bean
    public SampleA sampleA() {
        return new SampleA(commonBean());
    }

    @Bean
    public SampleB sampleB() {
        return new SampleB(commonBean());
    }
}
