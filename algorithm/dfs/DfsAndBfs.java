import java.util.*;

public class DfsAndBfs {

    static boolean[] visited;
    static List<Integer> dfsAnswers = new ArrayList<>();
    static List<Integer> bfsAnswers = new ArrayList<>();
    static List<ArrayList<Integer>> graph;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int V = scanner.nextInt();

        graph = new ArrayList<>();
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 1; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
        }

        visited[V] = true;
        dfsAnswers.add(V);
        dfs(N, V);
        for (Integer answer : dfsAnswers) {
            System.out.print(answer + " ");
        }

        visited = new boolean[N + 1];
        System.out.println();

        bfs(V);
        for (Integer answer : bfsAnswers) {
            System.out.print(answer + " ");
        }
    }

    private static void dfs(int N, int vertex) {
        if (vertex != N + 1) {
            for (Integer nextVertex : graph.get(vertex)) {
                if (!visited[nextVertex]) {
                    visited[nextVertex] = true;
                    dfsAnswers.add(nextVertex);
                    dfs(N, nextVertex);
                }
            }
        }
    }

    private static void bfs(int vertex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(vertex);
        visited[vertex] = true;
        bfsAnswers.add(vertex);

        while (!queue.isEmpty()) {
            Integer currentVertex = queue.poll();
            for (Integer nextVertex : graph.get(currentVertex)) {
                if (!visited[nextVertex]) {
                    visited[nextVertex] = true;
                    queue.offer(nextVertex);
                    bfsAnswers.add(nextVertex);
                }
            }

        }
    }
}
