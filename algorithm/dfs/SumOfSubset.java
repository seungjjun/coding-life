import java.util.Scanner;

public class SumOfSubset {

	static int N;
	static int[] numbers;
	static int totalSum;
	static String answer = "NO";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		numbers = new int[N];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = scanner.nextInt();
			totalSum += numbers[i];
		}

		dfs(0, 0);
		System.out.println(answer);
	}

	private static void dfs(int index, int sum) {
		if (totalSum - sum == sum) {
			answer = "YES";
		} else {
			if (index == N) {
				return;
			}

			sum += numbers[index];
			dfs(index + 1, sum);
			sum -= numbers[index];
			dfs(index + 1, sum);
		}
	}

}
