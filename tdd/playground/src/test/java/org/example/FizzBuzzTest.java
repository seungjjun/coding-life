package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {
    @Test
    void whenInputNumberMultiplesOfThree() {
        FizzBuzz fizzBuzz = new FizzBuzz();

        assertEquals("Fizz", fizzBuzz.fizzBuzz(3));
        assertEquals("Fizz", fizzBuzz.fizzBuzz(9));
    }

    @Test
    void whenInputNumberMultiplesOfFive() {
        FizzBuzz fizzBuzz = new FizzBuzz();

        assertEquals("Buzz", fizzBuzz.fizzBuzz(5));
        assertEquals("Buzz", fizzBuzz.fizzBuzz(10));
    }

    @Test
    void whenInputNumberMultiplesOfBothThreeAndFive() {
        FizzBuzz fizzBuzz = new FizzBuzz();

        assertEquals("FizzBuzz", fizzBuzz.fizzBuzz(15));
        assertEquals("FizzBuzz", fizzBuzz.fizzBuzz(60));
    }

}
