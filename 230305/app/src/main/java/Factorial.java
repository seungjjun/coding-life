public class Factorial {
    public int recursiveFactorial(int n) {
        if(n == 0 || n == 1) {
            return n;
        }

        return n * recursiveFactorial(n - 1);
    }

    public int memoizationFactorial(int n) {
        int[] memo = new int[n + 1];

        return memoization(n, memo);
    }

    private int memoization(int n, int[] memo) {
        if(n == 0 || n == 1) {
            return n;
        }

        memo[n] = n * memoization(n - 1, memo);
        return memo[n];
    }

    public int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i += 1) {
            for (int j = 0; j < array.length - i - 1; j += 1) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        return array;
    }
}
