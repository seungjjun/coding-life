import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DfsAndBfs {
    static ArrayList<Integer>[] lists;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int start = scanner.nextInt();

        lists = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i < N + 1; i += 1) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i += 1) {
            int left = scanner.nextInt();
            int right = scanner.nextInt();

            lists[left].add(right);
            lists[right].add(left);
        }

        for (int i = 1; i < lists.length; i += 1) {
            Collections.sort(lists[i]);
        }

        dfs(start);
        System.out.println();
        visited = new boolean[N + 1];
        bfs(start);
    }

    private static void dfs(int start) {
        System.out.print(start + " ");
        if(visited[start]) {
           return;
        }

        visited[start] = true;
        for (int index : lists[start]) {
            if(!visited[index]) {
                dfs(index);
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            System.out.print(currentNode + " ");

            for (int index : lists[currentNode]) {
                if(!visited[index]) {
                    visited[index] = true;
                    queue.add(index);
                }
            }
        }
    }
}
