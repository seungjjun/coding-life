import java.util.Scanner;

public class Leave {

	private static class Pair {
		private final int day;
		private final int point;

		public Pair(int day, int point) {
			this.day = day;
			this.point = point;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		Pair[] pairs = new Pair[n + 1];
		int[] dp = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			pairs[i] = new Pair(scanner.nextInt(), scanner.nextInt());
		}

		for (int i = 1; i < pairs.length; i++) {
			Pair pair = pairs[i];

			if (dp[i] == 0 && pair.day + i - 1 <= n) {
				dp[i] = pair.point;
			}

			for (int j = i + 1; j < pairs.length; j++) {
				if (i + pair.day <= j && j + pairs[j].day - 1 <= n) {
					dp[j] = Math.max(dp[j], dp[i] + pairs[j].point);
				}

			}
		}

		int max = 0;
		for (int point : dp) {
			max = Math.max(max, point);
		}
		System.out.println(max);
	}

}
