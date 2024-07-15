import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int TC = scanner.nextInt();

        List<Integer> answers = new ArrayList<>();

        for (int i = 0; i < TC; i++) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();

            Queue<Integer> queue = new LinkedList<>();
            Queue<Integer> indexQueue = new LinkedList<>();

            for (int j = 0; j < N; j++) {
                int number = scanner.nextInt();
                queue.offer(number);
                indexQueue.offer(j);
            }

            int answer = 0;
            boolean flag = true;

            while (!queue.isEmpty()) {
                Integer patient = queue.poll();
                Integer index = indexQueue.poll();

                for (Integer number : queue) {
                    flag = true;
                    if (number > patient) {
                        queue.offer(patient);
                        indexQueue.offer(index);
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    answer++;
                }

                if (index == M && flag) {
                    answers.add(answer);
                    break;
                }
            }
        }

        for (Integer answer : answers) {
            System.out.println(answer);
        }
    }
}
