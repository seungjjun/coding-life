import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {
    @Test
    void recursiveFactorial() {
        Factorial factorial = new Factorial();

        assertEquals(24, factorial.recursiveFactorial(4));
    }

    @Test
    void memoizationFactorial() {
        Factorial factorial = new Factorial();

        assertEquals(24, factorial.memoizationFactorial(4));
    }

    @Test
    void bubbleSort() {
        Factorial factorial = new Factorial();

        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, factorial.bubbleSort(new int[]{5, 3, 2, 4, 1}));
    }
}
