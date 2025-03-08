package com.seungjjun.aop.dynamicproxy;

import com.seungjjun.aop.proxy.Hello;
import com.seungjjun.aop.proxy.HelloTarget;
import java.lang.reflect.Proxy;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class UppercaseHandlerTest {

    @Test
    void dynamicProxy() {
        Hello proxiedHello = (Hello) Proxy.newProxyInstance(
            getClass().getClassLoader(),
            new Class[] {Hello.class},
            new UppercaseHandler(new HelloTarget())
        );

        assertThat(proxiedHello.sayHello("Jun")).isEqualTo("HELLO JUN");
        assertThat(proxiedHello.sayHi("Jun")).isEqualTo("HI JUN");
        assertThat(proxiedHello.sayThankYou("Jun")).isEqualTo("THANK YOU JUN");
    }

}
