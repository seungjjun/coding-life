import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Virus {

	static List<List<Integer>> graph = new ArrayList<>();
	static boolean[] visited;
	static int count = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int computerNumber = scanner.nextInt();
		int pair = scanner.nextInt();

		visited = new boolean[computerNumber + 1];
		for (int i = 0; i <= computerNumber; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < pair; i++) {
			int left = scanner.nextInt();
			int right = scanner.nextInt();

			graph.get(left).add(right);
			graph.get(right).add(left);
		}

		visited[1] = true;
		dfs(1);

		System.out.println(count);
	}

	private static void dfs(int computer) {
		if (!graph.get(computer).isEmpty()) {
			for (Integer number : graph.get(computer)) {
				if (!visited[number]) {
					visited[number] = true;
					count++;
					dfs(number);
				}
			}
		}
	}
}
