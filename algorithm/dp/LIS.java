import java.util.Scanner;

public class LIS {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int[] numbers = new int[n];
		int answer = 0;

		for (int i = 0; i < n; i++) {
			numbers[i] = scanner.nextInt();
		}

		int[] dy = new int[n];
		dy[0] = 1;

		for (int i = 1; i < numbers.length; i++) {
			int max = 0;
			for (int j = i - 1; j >= 0; j--) {
				if (numbers[i] > numbers[j]) {
					max = Math.max(max, dy[j]);
				}
			}
			dy[i] = max + 1;
			answer = Math.max(answer, dy[i]);
		}

		System.out.println(answer);
	}
}
