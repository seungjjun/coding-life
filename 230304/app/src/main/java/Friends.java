import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Friends {
    static ArrayList<Integer>[] friends;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int personNumber = Integer.parseInt(stringTokenizer.nextToken());
        int relationshipNumber = Integer.parseInt(stringTokenizer.nextToken());

        friends = new ArrayList[personNumber];
        visited = new boolean[personNumber];

        for (int i = 0; i < friends.length; i += 1) {
            friends[i] = new ArrayList<>();
        }

        for (int i = 0; i < relationshipNumber; i += 1) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());

            friends[start].add(end);
            friends[end].add(start);
        }

        for (int i = 0; i < relationshipNumber; i += 1) {
            count = 0;
            if(!visited[i]) {
                dfs(i);
            }

            if(count == 5) {
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
    }

    private static void dfs(int index) {
        if(visited[index] || count == 5) {
            return;
        }

        visited[index] = true;
        for (int i : friends[index]) {
            count += 1;
            dfs(i);
        }
    }
}
