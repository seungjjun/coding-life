import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato {

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static int[][] map;
	static Queue<int[]> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int M = Integer.parseInt(stringTokenizer.nextToken());
		int N = Integer.parseInt(stringTokenizer.nextToken());

		map = new int[N][M];
		queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 0; j < M; j++) {
				int tomato = Integer.parseInt(stringTokenizer.nextToken());
				map[i][j] = tomato;
				if (tomato == 1) {
					queue.offer(new int[]{i, j});
				}
			}
		}

		if (queue.size() == N * M) {
			System.out.println(0);
			return;
		}

		bfs();

		int count = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] != 0) {
					count = Math.max(map[i][j], count);
				}

				if (map[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}

		System.out.println(count - 1);
	}

	private static void bfs() {
		while (!queue.isEmpty()) {
			int[] poll = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nextX = poll[1] + dx[i];
				int nextY = poll[0] + dy[i];

				if (nextX >= 0 && nextX < map[0].length && nextY >= 0 && nextY < map.length) {
					if (map[nextY][nextX] == 0) {
						map[nextY][nextX] = map[poll[0]][poll[1]] + 1;
						queue.offer(new int[]{nextY, nextX});
					}
				}
			}
		}
	}
}
