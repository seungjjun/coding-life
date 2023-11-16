package com.example.opensearch.applications;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void solution() {
        Main main = new Main();
//        assertEquals(3, main.solution(4, 2, new int[]{1, 1, 1, 1}));
//
//        assertEquals(3, main.solution(10, 5, new int[]{1, 2, 3, 4, 2, 5, 3, 1, 1, 2}));
        assertEquals(4, main.solution(10, 4, new int[]{1, 3, 7, 2, 1, 1, 6, 1, 3, 4}));
    }
}
