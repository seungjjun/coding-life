package com.example.demo.security;

import com.example.demo.SampleA;
import com.example.demo.SampleB;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

class CustomConfigurationTest {
    @Test
    void proxyTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.register(CustomConfiguration.class);
        ac.refresh();

        SampleA sampleA = ac.getBean(SampleA.class);
        SampleB sampleB = ac.getBean(SampleB.class);

        assertThat(sampleA.getCommonBean()).isSameAs(sampleB.getCommonBean());
    }
}
