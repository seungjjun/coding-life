import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HideAndSeek {
    static int count = 0;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        if (n == k) {
            System.out.println(0);
            return;
        }

        visited = new boolean[100001];
        visited[n] = true;
        bfs(n, k);

        System.out.println(count);
    }

    private static void bfs(int n, int k) {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(n, 0));

        while (!queue.isEmpty()) {
            Position position = queue.poll();
            visited[position.distance] = true;

            if (position.distance > 100000) {
                continue;
            }

            if (position.distance == k) {
                count = position.count;
                return;
            }

            if (position.distance + 1 < visited.length && !visited[position.distance + 1]) {
                queue.offer(new Position(position.distance + 1, position.count + 1));
            }
            if (position.distance - 1 >= 0 && !visited[position.distance - 1]) {
                queue.offer(new Position(position.distance - 1, position.count + 1));
            }
            if (position.distance * 2 < visited.length && !visited[position.distance * 2]) {
                queue.offer(new Position(position.distance * 2, position.count + 1));
            }
        }
    }

    private static class Position {
        private final int distance;
        private final int count;

        public Position(int distance, int count) {
            this.distance = distance;
            this.count = count;
        }
    }
}
