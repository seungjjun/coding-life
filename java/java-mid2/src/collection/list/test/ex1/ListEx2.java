package collection.list.test.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListEx2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Integer> numbers = new ArrayList<>();

		System.out.println("n개의 정수를 입력하세요 (종료0)");

		while (true) {
			int number = scanner.nextInt();
			if (number == 0) {
				break;
			}
			numbers.add(number);
		}

		System.out.println("출력");
		for (int i = 0; i < numbers.size(); i += 1) {
			System.out.print(numbers.get(i));
			if (i < numbers.size() - 1) {
				System.out.print(", ");
			}
		}
	}
}
