import java.util.Scanner;

public class Fibonacci {
    public int[] arrayFibonacci(int n) {
        int[] fibonacci = new int[n];

        fibonacci[0] = 1;
        fibonacci[1] = 1;

        for (int i = 2; i < n; i += 1) {
            fibonacci[i] = fibonacci[i - 2] + fibonacci[i - 1];
        }

        return fibonacci;
    }

    public long recursiveFibonacci(int n) {
        return recursive(n);
    }

    private int recursive(int n) {
        if(n == 1 || n == 2) {
            return 1;
        }

        return recursive(n - 2) + recursive(n - 1);
    }

    public int memoizationFibonacci(int n) {
        int[] memo = new int[n + 1];

        return memoization(n, memo);
    }

    private int memoization(int n, int[] memo) {
        if(n == 0 || n == 1) {
            return n;
        }

        memo[n] = memoization(n - 2, memo) + memoization(n - 1, memo);
        return memo[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] fibonacciArray = new int[n + 1];

        fibonacciArray[0] = 1;
        fibonacciArray[1] = 1;

        for (int i = 2; i <= n; i += 1) {
            fibonacciArray[i] = fibonacciArray[i - 2] + fibonacciArray[i - 1];
        }

        System.out.println(fibonacciArray[n - 1]);
    }

    private static int fibonacci(int n) {
        if(n == 0 || n == 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
