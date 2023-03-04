import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {
    @Test
    void solution() {
        InsertionSort insertionSort = new InsertionSort();

        assertEquals(32, insertionSort.solution(5, new int[]{3, 1, 4, 3, 2}));
    }
}
