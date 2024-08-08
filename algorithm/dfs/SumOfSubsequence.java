import java.util.Scanner;

public class SumOfSubsequence {

	static int s;
	static int[] numbers;
	static int answer = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		s = scanner.nextInt();

		numbers = new int[n];

		for (int i = 0; i < n; i++) {
			numbers[i] = scanner.nextInt();
		}

		dfs(0,0);

		if (s == 0) {
			answer--;
		}

		System.out.println(answer);
	}

	private static void dfs(int depth, int sum) {
		if (depth == numbers.length) {
			if (sum == s) {
				answer++;
			}
			return;
		}

		dfs(depth + 1, sum + numbers[depth]);
		dfs(depth + 1, sum);
	}
}
