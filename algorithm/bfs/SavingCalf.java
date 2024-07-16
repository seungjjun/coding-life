import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SavingCalf {

	static final int[] direction = {1, -1, 5};

	static boolean[] visited;

	public static class Position {
		private final int position;
		private final int jump;

		public Position(int position, int jump) {
			this.position = position;
			this.jump = jump;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int S = scanner.nextInt();
		int E = scanner.nextInt();

		visited = new boolean[10001];
		Position position = new Position(S, 0);

		bfs(position, E);
	}

	private static void bfs(Position position, int goal) {
		Queue<Position> queue = new LinkedList<>();
		queue.offer(position);
		visited[position.position] = true;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Position currentPosition = queue.poll();

				for (int j = 0; j < 3; j++) {
					int nx = currentPosition.position + direction[j];
					if (nx == goal) {
						System.out.println(currentPosition.jump + 1);
						return;
					}
					if (nx >= 1 && nx <= 10000 && !visited[nx]) {
						visited[nx] = true;
						queue.offer(new Position(nx, currentPosition.jump + 1));
					}
				}
			}
		}
	}
}
