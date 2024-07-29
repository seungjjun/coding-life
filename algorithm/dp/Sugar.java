import java.util.Arrays;
import java.util.Scanner;

public class Sugar {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] dp = new int[n + 5];

		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[3] = 1;
		dp[5] = 1;

		for (int i = 0; i < n; i++) {
			if (dp[i] != Integer.MAX_VALUE) {
				dp[i + 3] = Math.min(dp[i + 3], dp[i] + 1);
				dp[i + 5] = Math.min(dp[i + 5], dp[i] + 1);
			}
		}

		if (dp[n] == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(dp[n]);
		}
	}
}
