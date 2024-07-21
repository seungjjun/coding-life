import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindDecimal {

	static List<Integer> answers;
	static int[] numbers;
	static int n;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();

		answers = new ArrayList<>();
		numbers = new int[n];

		dfs(2);
		dfs(3);
		dfs(5);
		dfs(7);

		for (int answer : answers) {
			System.out.println(answer);
		}
	}

	private static void dfs(int number) {
		if (!isPrime(number)) {
			return;
		}
		if (String.valueOf(number).length() == n) {
			answers.add(number);
			return;
		}
		number *= 10;
		for (int i = 1; i <= 9; i++) {
			number += i;
			dfs(number);
			number -= i;
		}
	}

	private static boolean isPrime(int number) {
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
