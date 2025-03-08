package com.seungjjun.aop.proxy;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class HelloUppercaseTest {

    @Test
    void simpleProxy() {
        Hello proxiedHello = new HelloUppercase(new HelloTarget());

        assertThat(proxiedHello.sayHello("Jun")).isEqualTo("HELLO JUN");
        assertThat(proxiedHello.sayHi("Jun")).isEqualTo("HI JUN");
        assertThat(proxiedHello.sayThankYou("Jun")).isEqualTo("THANK YOU JUN");
    }
}
