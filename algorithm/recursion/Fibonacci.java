import java.util.Scanner;

public class Fibonacci {

	static long[] fibonacci;

	// 재귀 + 메모제이션 피보나치 풀이
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		fibonacci = new long[n + 1];

		dfs(n);
		System.out.println(fibonacci[n]);
	}

	private static long dfs(int number) {
		if (number == 1) {
			return fibonacci[number] = 1;
		}
		if (number == 2) {
			return fibonacci[number] = 1;
		}

		return fibonacci[number] = dfs(number - 1) + dfs(number - 2);
	}


	/*
	재귀 피보나치 풀이

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		int sum = fibonacci(n);
		System.out.println(sum);
	}

	private static int fibonacci(int number) {
		if (number == 1) {
			return 1;
		}
		if (number == 2) {
			return 1;
		}

		return fibonacci(number - 1) + fibonacci(number - 2);
	}
	 */

	/*
	반복문 + 메모제이션 피보나치 풀이

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		long[] fibo = new long[n + 1];

		fibo[1] = 1;

		for (int i = 2; i <= n; i++) {
			fibo[i] = fibo[i - 1] + fibo[i - 2];
		}

		System.out.println(fibo[n]);
	}
	 */
}
