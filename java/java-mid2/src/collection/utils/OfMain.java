package collection.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OfMain {

	public static void main(String[] args) {
		// 불변
		List<Integer> list = List.of(1, 2, 3);
		Set<Integer> set = Set.of(1, 2, 3);
		Map<String, Integer> map = Map.of("k1", 1, "k2", 2);

		System.out.println("list = " + list);
		System.out.println("set = " + set);
		System.out.println("map = " + map);
		System.out.println("list.getClass() = " + list.getClass());

		// 가변 리스트
		ArrayList<Integer> mutableList = new ArrayList<>(list);
		mutableList.add(4);
		System.out.println("mutableList = " + mutableList);
		System.out.println("mutableList.getClass() = " + mutableList.getClass());

		// 불변 리스트
		List<Integer> unmodifiableList = Collections.unmodifiableList(mutableList);
		System.out.println("unmodifiableList.getClass() = " + unmodifiableList.getClass());

		// 예외 발생
		unmodifiableList.add(1);
	}
}
