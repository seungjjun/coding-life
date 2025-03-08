package com.seungjjun.aop.proxy;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class HelloTargetTest {

    @Test
    void simpleProxy() {
        Hello hello = new HelloTarget();

        assertThat(hello.sayHello("Jun")).isEqualTo("Hello Jun");
        assertThat(hello.sayHi("Jun")).isEqualTo("Hi Jun");
        assertThat(hello.sayThankYou("Jun")).isEqualTo("Thank you Jun");
    }

}
