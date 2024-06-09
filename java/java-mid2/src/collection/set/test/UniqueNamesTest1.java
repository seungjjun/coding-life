package collection.set.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueNamesTest1 {

	public static void main(String[] args) {
		Integer[] inputArr = {30, 20, 20, 10, 10};

		Set<Integer> hashSet = new HashSet<>(List.of(inputArr));
		for (Integer value : hashSet) {
			System.out.println(value + " ");
		}
	}
}
