package org.example.passwrod;

import org.example.password.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {
    @DisplayName("패스워드 초기화한다.")
    @Test
    void passwordTest() {
        // Given
        User user = new User();

        // When
        user.initPassword(new CorrectFixedPasswordGenerator());

        // Then
        assertThat(user.getPassword()).isNotNull();
    }

    @DisplayName("패스워드가 요구사항에 부합되지 않아 초기화가 되지 않는다.")
    @Test
    void passwordTest2() {
        // Given
        User user = new User();

        // When
        user.initPassword(new WrongFixedPasswordGenerator());

        // Then
        assertThat(user.getPassword()).isNull();
    }
}