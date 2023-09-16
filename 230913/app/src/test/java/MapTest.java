import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class MapTest {
    @Test
    void addAllNullToMapTest() {
        Map<String, List<Customer>> map = new HashMap<>();
        List<Customer> customers = new ArrayList<>();
        customers.add(null);
        customers.add(null);
        customers.add(null);
        customers.add(null);

        map.put("test", customers);
        List<Customer> result = map.computeIfAbsent("test", key -> new ArrayList<>());
        assertEquals(result.size(), 4);
    }

    @Test
    void nullFilterMapTest() {
        Map<String, EnumMap<Week, ValueList>> baseMap = new TreeMap<>();
        EnumMap<Week, ValueList> testEnumMap = new EnumMap<>(Week.class);
        ValueList valueList = new ValueList();

        valueList.add(null);
        valueList.add(null);

        testEnumMap.put(Week.MONDAY, valueList);

        baseMap.put("test1", testEnumMap);

        Map<String, EnumMap<Week, ValueList>> result = baseMap.entrySet().stream()
                .filter(e -> {
                    Collection<ValueList> values = e.getValue().values();
                    for (ValueList value : values) {
                        if (!value.containsOnlyNull()) {
                            return true;
                        }
                    }
                    return false;
                }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (k, v) -> v, TreeMap::new));

        assertEquals(0, result.values().size());
    }
}
