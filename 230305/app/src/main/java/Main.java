import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        int[] numbers = new int[N];

        for (int i = 0; i < numbers.length; i += 1) {
            numbers[i] = scanner.nextInt();
        }

        Arrays.sort(numbers);

        System.out.println(numbers[K - 1]);
    }
}

