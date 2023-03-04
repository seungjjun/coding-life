import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Virus {
    static ArrayList<Integer>[] arrayLists;
    static boolean[] virused;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int computerNumber = Integer.parseInt(bufferedReader.readLine());
        int computerPair = Integer.parseInt(bufferedReader.readLine());

        arrayLists = new ArrayList[computerNumber + 1];
        virused = new boolean[computerNumber + 1];

        for (int i = 1; i < computerNumber + 1; i += 1) {
            arrayLists[i] = new ArrayList<>();
        }

        for (int i = 1; i < computerPair + 1; i += 1) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());

            arrayLists[start].add(end);
            arrayLists[end].add(start);
        }

        count = 0;
        if(!virused[1]) {
            dfs(1);
        }

        System.out.println(count);
    }

    private static void dfs(int index) {
        if(virused[index]) {
            return;
        }

        virused[index] = true;
        for (int i : arrayLists[index]) {
            if (!virused[i]) {
                count += 1;
                dfs(i);
            }
        }
    }
}
