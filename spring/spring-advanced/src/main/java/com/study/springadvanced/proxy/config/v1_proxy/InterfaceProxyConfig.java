package com.study.springadvanced.proxy.config.v1_proxy;

import com.study.springadvanced.proxy.app.v1.*;
import com.study.springadvanced.proxy.config.v1_proxy.interface_proxy.OrderControllerInterfaceProxy;
import com.study.springadvanced.proxy.config.v1_proxy.interface_proxy.OrderRepositoryInterfaceProxy;
import com.study.springadvanced.proxy.config.v1_proxy.interface_proxy.OrderServiceInterfaceProxy;
import com.study.springadvanced.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InterfaceProxyConfig {

    @Bean
    public OrderControllerV1 orderController(LogTrace logTrace) {
        OrderControllerV1Impl orderControllerV1 = new OrderControllerV1Impl(orderService(logTrace));
        return new OrderControllerInterfaceProxy(orderControllerV1, logTrace);
    }

    @Bean
    public OrderServiceV1 orderService(LogTrace logTrace) {
        OrderServiceV1Impl orderServiceV1 = new OrderServiceV1Impl(orderRepository(logTrace));
        return new OrderServiceInterfaceProxy(orderServiceV1, logTrace);
    }

    @Bean
    public OrderRepositoryV1 orderRepository(LogTrace logTrace) {
        OrderRepositoryV1Impl orderRepositoryV1 = new OrderRepositoryV1Impl();
        return new OrderRepositoryInterfaceProxy(orderRepositoryV1, logTrace);
    }
}
