package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringCalculatorTest {
    @Test
    public void testEmptyString() {
        StringCalculator stringCalculator = new StringCalculator();

        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void testOneNumber() {
        StringCalculator stringCalculator = new StringCalculator();

        assertEquals(1, stringCalculator.add("1"));
        assertEquals(10, stringCalculator.add("10"));
    }

    @Test
    public void testTwoNumbers() {
        StringCalculator stringCalculator = new StringCalculator();

        assertEquals(3, stringCalculator.add("1,2"));
    }

    @Test
    public void testMultipleNumbers() {
        StringCalculator stringCalculator = new StringCalculator();

        assertEquals(10, stringCalculator.add("1,2,3,4"));
        assertEquals(15, stringCalculator.add("1,2,3,4,5"));
    }

    @Test
    public void testNewLineAsDelimiter() {
        StringCalculator stringCalculator = new StringCalculator();

        assertEquals(6, stringCalculator.add("1,2\n3"));
        assertEquals(6, stringCalculator.add("1\n2,3"));
        assertEquals(6, stringCalculator.add("1\n2\n3"));
    }

    @Test
    public void testDifferentDelimiter() {
        StringCalculator stringCalculator = new StringCalculator();

        assertEquals(3, stringCalculator.add("//;\n1;2"));
    }

    @Test
    public void testSeparatorLocationAtTheEnd() {
        StringCalculator stringCalculator = new StringCalculator();

        assertThrows(RuntimeException.class, () -> {
            stringCalculator.add("1,2\n");
        });

        assertThrows(RuntimeException.class, () -> {
            stringCalculator.add("1,2,");
        });
    }

    @Test
    void testDifferentDelimiters() {
        StringCalculator stringCalculator = new StringCalculator();

        assertEquals(4, stringCalculator.add("//;\n1;3"));
        assertEquals(6, stringCalculator.add("//|\n1|2|3"));
        assertEquals(7, stringCalculator.add("//sep\n2sep5"));
    }

    @Test
    public void testNegativeNumbers() {
        StringCalculator stringCalculator = new StringCalculator();

        Exception exception = assertThrows(RuntimeException.class, () -> stringCalculator.add("1,-2"));
        assertEquals("Negative number(s) not allowed: [-2]", exception.getMessage());

        exception = assertThrows(RuntimeException.class, () -> stringCalculator.add("2,-4,-9"));
        assertEquals("Negative number(s) not allowed: [-4, -9]", exception.getMessage());
    }

    @Test
    public void testIgnoreNumbersAbove1000() {
        StringCalculator stringCalculator = new StringCalculator();

        assertEquals(2, stringCalculator.add("2,1001"));
    }
}