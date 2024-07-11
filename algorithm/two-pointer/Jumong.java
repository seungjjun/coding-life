import java.util.Arrays;
import java.util.Scanner;

public class Jumong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = scanner.nextInt();
        }

        Arrays.sort(numbers);

        int answer = 0;
        int left = 0;
        int right = numbers.length - 1;

        while (true) {
            int leftNumber = numbers[left];
            int rightNumber = numbers[right];

            if (left >= right) {
                break;
            }

            if (leftNumber + rightNumber == M) {
                answer++;
                left++;
                continue;
            }

            if (leftNumber + rightNumber > M) {
                right--;
            }

            if (leftNumber + rightNumber < M) {
                left++;
            }
        }

        System.out.println(answer);
    }
}
