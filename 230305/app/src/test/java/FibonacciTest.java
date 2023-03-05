import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {
    @Test
    void arrayFibonacci() {
        Fibonacci fibonacci = new Fibonacci();

        assertArrayEquals(new int[]{1, 1, 2, 3, 5, 8, 13, 21, 34, 55}, fibonacci.arrayFibonacci(100));
    }

    @Test
    void recursiveFibonacci() {
        Fibonacci fibonacci = new Fibonacci();

        assertEquals(55, fibonacci.recursiveFibonacci(10));
    }

    @Test
    void memoizationFibonacci() {
        Fibonacci fibonacci = new Fibonacci();

        assertEquals(55, fibonacci.memoizationFibonacci(10));
    }
}
