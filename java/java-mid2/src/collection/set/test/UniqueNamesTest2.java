package collection.set.test;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class UniqueNamesTest2 {

	public static void main(String[] args) {
		Integer[] inputArr = {30, 20, 20, 10, 10};

		Set<Integer> linkedHashSet = new LinkedHashSet<>(List.of(inputArr));
		for (Integer value : linkedHashSet) {
			System.out.println(value + " ");
		}
	}
}
