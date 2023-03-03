package coding.test.practice;

import java.util.Scanner;

public class AddNumbers {
    public static void main(String[] args) {
        int answer = 0;
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        String stringNumbers = scanner.next();

        char[] numbers = stringNumbers.toCharArray();

        for (int i = 0; i < numbers.length; i += 1) {
            answer += numbers[i] - 48;
        }

        System.out.println("answer = " + answer);
    }
}
