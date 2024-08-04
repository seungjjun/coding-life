import java.util.Scanner;

public class Combination {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int r = scanner.nextInt();

		int[][] memo = new int[n + 1][r + 1];

		System.out.println(combination(n, r, memo));
	}

	private static int combination(int n, int r, int[][] memo) {
		if (memo[n][r] > 0) {
			return memo[n][r];
		}
		if (n == r || r == 0) {
			return 1;
		}
		return memo[n][r] = combination(n - 1, r - 1, memo) + combination(n - 1, r, memo);
	}
}
