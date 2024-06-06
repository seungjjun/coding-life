package collection.list.test.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListEx3 {
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

		int sum = 0;
		for (int number : numbers) {
			sum += number;
		}
		double average = (double) sum / numbers.size();

		System.out.println("입력한 정수의 합계: " + sum);
		System.out.println("입력한 정수의 평균: " + average);
	}
}
