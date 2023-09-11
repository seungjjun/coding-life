import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnumMapSampleTest {
    private EnumMap<Color, String> map = new EnumMap<>(Color.class);

    @BeforeEach
    void setUp() {
        map.put(Color.RED, Color.RED.getName());
        map.put(Color.GREEN, Color.GREEN.getName());
        map.put(Color.BLUE, Color.BLUE.getName());
    }

    @Test
    void enumMapTest() {
        assertEquals(map.get(Color.RED), Color.RED.getName());
        assertEquals(map.get(Color.GREEN), Color.GREEN.getName());
    }

    @Test
    void enumMapOrderTest() {
        Integer[] mapOrder = new Integer[map.size()];

        int index = 0;
        for (Map.Entry<Color, String> entry : map.entrySet()) {
            mapOrder[index++] = entry.getKey().ordinal();
        }

        assertEquals(mapOrder[0], Color.RED.ordinal());
        assertEquals(mapOrder[1], Color.GREEN.ordinal());
        assertEquals(mapOrder[2], Color.BLUE.ordinal());
    }
}
