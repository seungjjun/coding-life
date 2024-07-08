package cleancode;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int number = scanner.nextInt();
		int[] numbers = new int[number];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = scanner.nextInt();
		}

		for (int i = 0; i < numbers.length; i++) {
			String originalNumber = String.valueOf(numbers[i]);
			String[] split = originalNumber.split("");
			StringBuilder reversedNumber = new StringBuilder();
			for (int j = split.length - 1; j >= 0; j--) {
				reversedNumber.append(split[j]);
			}
			String string = reversedNumber.toString();

			if (string.charAt(0) == '0') {
				string = string.substring(1);
			}

			int reverse = Integer.parseInt(string);
			if (reverse == 2) {
				System.out.print(reverse + " ");
				continue;
			}

			for (int j = 2; j < reverse; j++) {
				if (reverse % j == 0) {
					break;
				}
				if (reverse == j + 1) {
					System.out.print(reverse + " ");
				}
			}
		}
	}

	public static ArrayList<Integer> solution(int n, int[] arr) {
		ArrayList<Integer> answer = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int temp = arr[i];
			int res = 0;
			while (temp > 0) {
				int t = temp % 10;
				res = res * 10 + t;
				temp = temp / 10;
			}

			if (isPrime(res)) {
				answer.add(res);
			}
		}
		return answer;
	}

	private static boolean isPrime(int num) {
		if (num == 1) {
			return false;
		}

		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
