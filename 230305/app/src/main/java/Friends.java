import java.util.ArrayList;
import java.util.Scanner;

public class Friends {
    static ArrayList<Integer>[] friends;
    static boolean[] visited;
    static boolean trigger;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int personNumber = scanner.nextInt();
        int relationshipNumber = scanner.nextInt();

        friends = new ArrayList[personNumber];
        visited = new boolean[personNumber];

        for (int i = 0; i < friends.length; i += 1) {
            friends[i] = new ArrayList<>();
        }

        for (int i = 0; i < relationshipNumber; i += 1) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();

            friends[start].add(end);
            friends[end].add(start);
        }

        for (int i = 0; i < friends.length; i += 1) {
            dfs(i, 1);

            if(trigger) {
                break;
            }
        }

        if (trigger) {
            System.out.println(1);
        }

        if (!trigger) {
            System.out.println(0);
        }
    }

    private static void dfs(int index, int depth) {
        if (visited[index] || depth == 5) {
            trigger = true;
            return;
        }

        visited[index] = true;
        for (int i : friends[index]) {
            if (!visited[i]) {
                dfs(i, depth + 1);
            }
        }
        visited[index] = false;
    }
}
