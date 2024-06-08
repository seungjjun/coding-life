package collection.set;

public class MyHashSetV1Main {

	public static void main(String[] args) {
		MyHashSetV1 set = new MyHashSetV1(10);
		set.add(1); // O(1)
		set.add(2); // O(n)
		set.add(5); // O(n)
		set.add(8); // O(n)
		set.add(14); // O(n)
		set.add(99); // O(n)
		set.add(9); // O(n)
		System.out.println(set);

		int searchValue = 9;
		boolean contains = set.contains(searchValue);
		System.out.println("contains = " + contains);

		boolean removeResult = set.remove(searchValue);
		System.out.println("removeResult = " + removeResult);
		System.out.println(set);
	}
}
