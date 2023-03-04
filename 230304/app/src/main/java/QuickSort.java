import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuickSort {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        int[] A = new int[N];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i += 1) {
            A[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        quickSort(A, 0, N - 1, K - 1);
        System.out.println(A[K - 1]);
    }

    private static void quickSort(int[] numbers, int start, int end, int K) {
        if(start < end) {
            int pivot = partition(numbers, start, end);

            if(pivot == K) {
                return;
            }
            if(pivot > K) {
                quickSort(numbers, start, pivot - 1, K);
            }

            if(pivot < K) {
                quickSort(numbers, pivot + 1, end, K);
            }
        }
    }

    private static int partition(int[] numbers, int start, int end) {
        if(start + 1 == end) {
            if(numbers[start] > numbers[end]) {
                swap(numbers, start, end);
            }
            return end;
        }

        int pivot = numbers[(start + end) / 2];
        while (start <= end) {
            while (numbers[start] < pivot) {
                start += 1;
            }
            while (numbers[end] > pivot) {
                end -= 1;
            }

            if(start <= end) {
                swap(numbers, start, end);
                start += 1;
                end -= 1;
            }
        }
        return start;
    }

    private static void swap(int[] numbers, int start, int end) {
        int temp = numbers[start];
        numbers[start] = numbers[end];
        numbers[end] = temp;
    }
}
