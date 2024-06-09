package collection.set.javaset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class JavaSetMain {

	public static void main(String[] args) {
		HashSet<String> hashSet = new HashSet<>(); // O(1)
		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(); // O(1)
		TreeSet<String> treeSet = new TreeSet<>(); // O(log n)

		run(hashSet);
		run(linkedHashSet);
		run(treeSet);
	}

	private static void run(Set<String> set) {
		System.out.println("set = " + set.getClass());

		set.add("C");
		set.add("B");
		set.add("A");
		set.add("1");
		set.add("2");

		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
	}
}
