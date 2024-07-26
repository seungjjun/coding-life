import java.util.Arrays;
import java.util.Scanner;

public class TwoNumberSum {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = scanner.nextInt();
		}
		int x = scanner.nextInt();

		Arrays.sort(numbers);

		int answer = 0;
		int lt = 0;
		int rt = n - 1;

		while (lt < rt) {
			int sum = numbers[lt] + numbers[rt];
			if (sum == x) {
				answer++;
				lt++;
				rt--;
				continue;
			}

			if (sum > x) {
				rt--;
			}

			if (sum < x) {
				lt++;
			}
		}

		System.out.println(answer);
	}

}
