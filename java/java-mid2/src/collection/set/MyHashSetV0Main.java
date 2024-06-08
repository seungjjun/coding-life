package collection.set;

public class MyHashSetV0Main {
	public static void main(String[] args) {
		MyHashSetV0 set = new MyHashSetV0();
		set.add(1); // O(1)
		set.add(2); // O(n)
		set.add(3); // O(n)
		set.add(4); // O(n)
		set.add(5); // O(n)
		System.out.println(set);

		boolean result = set.add(4); // O(n)
		System.out.println("중복 데이터 저장 결과 = " + result);
		System.out.println(set);

		System.out.println("set.contains(3) = " + set.contains(3)); // O(n)
		System.out.println("set.contains(99) = " + set.contains(99)); // O(n)

		// 데이터가 많아질 수록 성능 Down
		// 데이터 추가 시 중복 검사를 하기 때문에 O(n) 으로 성능이 안 좋음
	}
}
