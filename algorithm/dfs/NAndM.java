import java.util.Scanner;

public class NAndM {

	static int n, m;
	static int[] pm;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();

		pm = new int[m];
		visited = new boolean[n];

		dfs(0);
	}

	private static void dfs(int depth) {
		if (depth == m) {
			for (Integer number : pm) {
				System.out.print(number + " ");
			}
			System.out.println();
		} else {
			for (int i = 0; i < n; i++) {
				if (!visited[i]) {
					visited[i] = true;
					pm[depth] = i + 1;
					dfs(depth + 1);
					visited[i] = false;
				}
			}
		}
	}
}
