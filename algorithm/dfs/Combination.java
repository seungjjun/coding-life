import java.util.Scanner;

public class Combination {

	static int n, m;
	static int[] combination;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();

		combination = new int[m];

		dfs(0, 1);
	}

	private static void dfs(int depth, int start) {
		if (depth == m) {
			for (Integer number : combination) {
				System.out.print(number + " ");
			}
			System.out.println();
		} else {
			for (int i = start; i <= n; i++) {
				combination[depth] = i;
				dfs(depth + 1, i + 1);
			}
		}
	}


}
