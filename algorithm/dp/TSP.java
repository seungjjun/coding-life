import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TSP {

	static int n;
	static int[][] map;
	static boolean[] visited;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		n = Integer.parseInt(stringTokenizer.nextToken());

		map = new int[n + 1][n + 1];
		visited = new boolean[n + 1];
		answer = Integer.MAX_VALUE;

		for (int i = 1; i <= n; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
			}
		}

		for (int i = 1; i <= n; i++) {
			dfs(i, i, 0, 0);
		}

		System.out.println(answer);
	}

	private static void dfs(int start, int current, int sum, int count) {
		if (count == n && current == start) {
			answer = Math.min(answer, sum);
			return;
		}

		for (int i = 1; i < map[current].length; i++) {
			if (map[current][i] != 0 && !visited[i]) {
				visited[i] = true;
				dfs(start, i, sum + map[current][i], count + 1);
				visited[i] = false;
			}
		}
	}
}
