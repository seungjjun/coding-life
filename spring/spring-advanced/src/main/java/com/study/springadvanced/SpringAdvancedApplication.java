package com.study.springadvanced;

import com.study.springadvanced.proxy.config.AppV1Config;
import com.study.springadvanced.proxy.config.AppV2Config;
import com.study.springadvanced.proxy.config.v1_proxy.ConcreteProxyConfig;
import com.study.springadvanced.proxy.config.v1_proxy.InterfaceProxyConfig;
import com.study.springadvanced.proxy.config.v2_dynamicproxy.handler.DynamicProxyBasicConfig;
import com.study.springadvanced.proxy.config.v2_dynamicproxy.handler.DynamicProxyFilterConfig;
import com.study.springadvanced.trace.logtrace.LogTrace;
import com.study.springadvanced.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

//@Import({AppV1Config.class, AppV2Config.class})
//@Import(InterfaceProxyConfig.class)
//@Import(ConcreteProxyConfig.class)
//@Import(DynamicProxyBasicConfig.class)
@Import(DynamicProxyFilterConfig.class)
@SpringBootApplication(scanBasePackages = "com.study.springadvanced.proxy.app")
public class SpringAdvancedApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAdvancedApplication.class, args);
    }

    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }

}
