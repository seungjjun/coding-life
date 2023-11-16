package com.example.security;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PrivacyTest {
    @Test
    void convertDate() {
        Privacy privacy = new Privacy();

        assertEquals("2021-05-21", privacy.convertLocalDate("2021.05.21"));
    }

    @Test
    void plusDate() {
        Privacy privacy = new Privacy();

        assertEquals(LocalDate.of(2022, 7, 19), privacy.plusDate(2, LocalDate.of(2022, 5, 20)));
    }

    @Test
    void solution() {
        Privacy privacy = new Privacy();

        assertArrayEquals(new int[]{1, 3}, privacy.solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"}));
    }
}
