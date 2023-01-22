import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    private Stack stack;

    @BeforeEach
    void setup() {
        stack = new Stack(10);

        stack.push('A');
        stack.push('B');
        stack.push('C');
    }

    @Test
    void checkSize() {
        assertEquals(3, stack.size());
    }

    @Test
    void push() {
        assertEquals(3, stack.size());

        stack.push('D');

        assertEquals(4, stack.size());
    }

    @Test
    void pop() {
        assertEquals(3, stack.size());

        stack.pop();

        assertEquals(2, stack.size());
    }

    @Test
    void peek() {
        assertEquals('C', stack.peek());
    }

    @Test
    void clear() {
        assertEquals(3, stack.size());

        stack.clear();

        assertEquals(0, stack.size());
    }

    @Test
    void isFull() {
        assertFalse(stack.isFull());
    }

    @Test
    void isEmpty() {
        assertFalse(stack.isEmpty());

        stack.clear();

        assertTrue(stack.isEmpty());
    }
}
