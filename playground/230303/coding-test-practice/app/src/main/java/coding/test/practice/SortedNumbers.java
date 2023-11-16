package coding.test.practice;

import java.util.Scanner;

public class SortedNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        int answer = 0;

        int A[] = new int[100001];
        int S[] = new int[100001];

        for (int i = 1; i < 10000; i += 1) {
            A[i] = (int) (Math.random() * Integer.MAX_VALUE);
            S[i] = S[i - 1] + A[i];
        }

        for (int t = 1; t < testCase; t += 1) {
            int query = scanner.nextInt();

            for (int i = 0; i < query; i += 1) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                answer += S[end] - S[start - 1];
                System.out.println(testCase + " " + answer);
            }
        }
    }
}
