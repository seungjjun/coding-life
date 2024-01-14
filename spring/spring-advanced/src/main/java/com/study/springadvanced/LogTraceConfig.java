package com.study.springadvanced;

import com.study.springadvanced.trace.logtrace.FieldLogTrace;
import com.study.springadvanced.trace.logtrace.LogTrace;
import com.study.springadvanced.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }
}
