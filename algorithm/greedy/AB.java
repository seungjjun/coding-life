import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AB {

	static long answer = -1;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long a = scanner.nextInt();
		long b = scanner.nextInt();

		bfs(a, b);

		System.out.println(answer);
	}

	private static void bfs(long a, long b) {
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(a, 1));

		while (!queue.isEmpty()) {
			Pair current = queue.poll();
			if (current.number > b) {
				answer = -1;
				continue;
			}

			if (current.number == b) {
				answer = current.count;
				break;
			}

			queue.offer(new Pair(current.number * 2, current.count + 1));
			queue.offer(new Pair((current.number * 10) + 1, current.count + 1));
		}
	}

	private static class Pair {
		private final long number;
		private final int count;

		public Pair(long number, int count) {
			this.number = number;
			this.count = count;
		}
	}

}
