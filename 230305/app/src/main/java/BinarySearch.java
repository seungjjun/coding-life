import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] numbers = new int[N];
        for (int i = 0; i < N; i += 1) {
            numbers[i] = scanner.nextInt();
        }
        Arrays.sort(numbers);

        int M = scanner.nextInt();
        for (int i = 0; i < M; i += 1) {
            int target = scanner.nextInt();
            int start = 0;
            int end = numbers.length - 1;
            int answer = 0;

            while (start <= end) {
                int midIndex = (start + end) / 2;
                int mid = numbers[midIndex];

                if(mid > target) {
                    end = midIndex - 1;
                    continue;
                }

                if (mid < target) {
                    start = midIndex + 1;
                    continue;
                }

                answer = 1;
                break;
            }

            System.out.println(answer);
        }
    }
}
