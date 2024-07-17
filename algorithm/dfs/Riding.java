import java.util.Scanner;

public class Riding {
	static int C;
	static int answer = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		C = scanner.nextInt();
		int N = scanner.nextInt();

		int[] dogs = new int[N];

		for (int i = 0; i < N; i++) {
			dogs[i] = scanner.nextInt();
		}

		dfs(0, dogs, 0);
		System.out.println(answer);
	}

	private static void dfs(int index, int[] dogs, int sum) {
		if (sum > C) {
			return;
		}
		if (index == dogs.length) {
			answer = Math.max(answer, sum);
		} else {
			dfs(index + 1, dogs, sum + dogs[index]);
			dfs(index + 1, dogs, sum);
		}
	}
}
