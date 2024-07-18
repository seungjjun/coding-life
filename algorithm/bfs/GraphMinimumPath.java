import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GraphMinimumPath {

    static boolean[] visited;
    static int[] distance;
    static ArrayList<ArrayList<Integer>> graph;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
    
        graph = new ArrayList<>();
        distance = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph.get(a).add(b);
        }

        bfs(1);
        for (int i = 2; i < distance.length; i++) {
            System.out.println(i + " : " + distance[i]);
        }
    }

    private static void bfs(int vertex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(vertex);
        distance[vertex] = 0;
        visited[vertex] = true;

        while (!queue.isEmpty()) {
            Integer currentVertex = queue.poll();
            for (Integer nextVertex : graph.get(currentVertex)) {
                if (!visited[nextVertex]) {
                    visited[nextVertex] = true;
                    queue.offer(nextVertex);
                    distance[nextVertex] = distance[currentVertex] + 1;
                }
            }
        }
    }
}

// 다른 풀이
/*
    static int N;
    static int M;
    static boolean[] visited;
    static Map<Integer, Integer> answers = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        visited = new boolean[N + 1];
        for (int i = 0; i <= M; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            list.get(a).add(b);
        }

        visited[1] = true;
        bfs(list);

        for (Map.Entry<Integer, Integer> entry : answers.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    private static void bfs(ArrayList<ArrayList<Integer>> list) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Integer currentNode = q.poll();
                ArrayList<Integer> nodes = list.get(currentNode);

                for (Integer nextNode : nodes) {
                    if (!visited[nextNode]) {
                        visited[nextNode] = true;
                        q.offer(nextNode);
                        answers.put(nextNode, level);
                    }
                }
            }

            level++;
        }
    }
 */