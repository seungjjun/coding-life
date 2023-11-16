package com.data.opensearch.controller;

import java.util.*;

public class Solution {
    public int solution(int n) {
        Map<Integer, Integer> numbers = new HashMap<>();
        for (int i = 2; i <= n; i += 1) {
            numbers.put(i, i);
        }
        int divisor = 2;
        int keyNumber = 2;
        while (divisor <= n) {
            if (numbers.containsKey(keyNumber)) {
                int number = numbers.get(keyNumber);
                if (number % divisor == 0) {
                    int i = 2;
                    while (number * i <= n) {
                        numbers.remove(number * i);
                        i += 1;
                    }
                }
            }
            keyNumber += 1;
            divisor += 1;
        }

        return numbers.size();
    }
}
