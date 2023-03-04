import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DeepthFirstSearch {
    static ArrayList<Integer>[] A;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int node = Integer.parseInt(stringTokenizer.nextToken());
        int edge = Integer.parseInt(stringTokenizer.nextToken());
        A = new ArrayList[node + 1];
        visited = new boolean[node + 1];

        for (int i = 1; i < node + 1; i += 1) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge; i += 1) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());
            A[start].add(end);
            A[end].add(start);
        }

        int count = 0;
        for (int i = 1; i < node + 1; i += 1) {
            if(!visited[i]) {
                count += 1;
                DFS(i);
            }
        }

        System.out.println(count);
    }

    private static void DFS(int value) {
        if(visited[value]) {
            return;
        }

        visited[value] = true;
        for (int i : A[value]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }
}
