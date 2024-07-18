import java.util.Scanner;

public class Permutation {

    static int N;
    static int M;
    static int[] numbers;
    public static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        numbers = new int[M];

        dfs(0);
        System.out.println(stringBuilder);
    }

    private static void dfs(int index) {
        if (index == M) {
            for (int number : numbers) {
                stringBuilder.append(number).append(" ");
            }
            stringBuilder.append('\n');
        } else {
            for (int i = 1; i <= N; i++) {
                numbers[index] = i;
                dfs(index + 1);
            }
        }
    }

}
