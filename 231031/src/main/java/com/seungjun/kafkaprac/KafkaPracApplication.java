package com.seungjun.kafkaprac;

import com.seungjun.kafkaprac.producer.ClipProducer;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.nio.charset.StandardCharsets;

@SpringBootApplication
public class KafkaPracApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaPracApplication.class, args);
    }

    @Bean
    public ApplicationRunner runner(ClipProducer clipProducer) {
        return args -> {
            clipProducer.async("clip3", "Hello, Clip3-async.");
            clipProducer.sync("clip3", "Hello, Clip3-sync.");
            clipProducer.routingSendBytes("clip3", "Hello, Clip3-routing");
            clipProducer.routingSendBytes("clip3-bytes", "Hello, Clip3-bytes".getBytes(StandardCharsets.UTF_8));
            clipProducer.replyingSend("clip3-request", "Ping Clip3");
        };
    }
}
