package cleancode;

import java.util.Scanner;

public class Solution2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt();
		int[] numbers = new int[N];

		for (int i = 0; i < N - 1; i++) {
			numbers[i] = i + 1;
		}

		int sum = 0;
		int lt = 0;
		int rt = 0;
		int answer = 0;

		while (rt < N) {
			sum += numbers[rt++];

			if (sum == N) {
				answer++;
			}

			while (sum >= N) {
				sum -= numbers[lt++];
				if (sum == N) {
					answer++;
				}
			}
		}

		System.out.println(answer);
	}
}
