import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] times = new int[N];
        int[] accumulateTimes = new int[N];

        for (int i = 0; i < times.length; i += 1) {
            times[i] = scanner.nextInt();
        }

        for (int i = 1; i < N; i += 1) {
            int index = i - 1;
            int targetValue = times[i];

            while (index >= 0 && targetValue < times[index]) {
                times[index + 1] = times[index];
                index -= 1;
            }

            times[index + 1] = targetValue;
        }

        int answer = 0;

        accumulateTimes[0] = times[0];
        answer += accumulateTimes[0];

        for (int i = 1; i < accumulateTimes.length; i += 1) {
            accumulateTimes[i] = accumulateTimes[i - 1] + times[i];
            answer += accumulateTimes[i];
        }

        System.out.println(answer);
    }

    public int solution(int N, int[] times) {
        int[] accumulateTimes = new int[N];

        for (int i = 1; i < N; i += 1) {
            int index = i - 1;
            int targetValue = times[i];

            while (index >= 0 && targetValue < times[index]) {
                times[index + 1] = times[index];
                index -= 1;
            }

            times[index + 1] = targetValue;
        }

        int answer = 0;

        accumulateTimes[0] = times[0];
        answer += accumulateTimes[0];

        for (int i = 1; i < accumulateTimes.length; i += 1) {
            accumulateTimes[i] = accumulateTimes[i - 1] + times[i];
            answer += accumulateTimes[i];
        }

        return answer;
    }
}
