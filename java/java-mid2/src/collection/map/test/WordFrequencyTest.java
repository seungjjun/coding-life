package collection.map.test;

import java.util.HashMap;
import java.util.Map;

public class WordFrequencyTest {

	public static void main(String[] args) {
		String text = "orange banana apple apple banana apple";

		Map<String, Integer> result = new HashMap<>();

		for (String key : text.split(" ")) {
			result.put(key, result.getOrDefault(key, 0) + 1);
		}

		System.out.println(result);
	}
}
