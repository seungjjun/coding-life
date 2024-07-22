import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Maze {

	static int n;
	static int m;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] maze;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		n = Integer.parseInt(stringTokenizer.nextToken());
		m = Integer.parseInt(stringTokenizer.nextToken());

		maze = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i += 1) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			String line = stringTokenizer.nextToken();
			for (int j = 0; j < m; j += 1) {
				maze[i][j] = Integer.parseInt(line.substring(j, j + 1));
			}
		}

		bfs(0, 0);

		System.out.println(maze[n - 1][m - 1]);
	}

	private static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		visited[y][x] = true;
		queue.offer(new int[]{y, x});

		while (!queue.isEmpty()) {
			int[] current = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nextY = current[0] + dy[i];
				int nextX = current[1] + dx[i];

				if (nextY >= 0 & nextX >= 0 && nextY < n && nextX < m) {
					if (maze[nextY][nextX] != 0 && !visited[nextY][nextX]) {
						visited[nextY][nextX] = true;
						maze[nextY][nextX] = maze[current[0]][current[1]] + 1;
						queue.offer(new int[]{nextY, nextX});
					}
				}
			}
		}
	}
}
