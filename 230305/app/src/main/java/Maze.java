import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Maze {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int[][] maze;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        maze = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i += 1) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String line = stringTokenizer.nextToken();
            for (int j = 0; j < M; j += 1) {
                maze[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }

        bfs(0, 0);
        System.out.println(maze[N - 1][M - 1]);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] currentPosition = queue.poll();

            for (int i = 0; i < 4; i += 1) {
                int nextX = currentPosition[0] + dx[i];
                int nextY = currentPosition[1] + dy[i];
                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {
                    if (!visited[nextX][nextY] && maze[nextX][nextY] != 0) {
                        visited[nextX][nextY] = true;
                        maze[nextX][nextY] = maze[currentPosition[0]][currentPosition[1]] + 1;
                        queue.add(new int[]{nextX, nextY});
                    }
                }
            }
        }
    }
}
