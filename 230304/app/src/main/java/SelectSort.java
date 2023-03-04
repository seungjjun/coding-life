import java.util.Scanner;

public class SelectSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stringNumbers = scanner.next();

        int[] numbers = new int[stringNumbers.length()];

        for (int i = 0; i < numbers.length; i += 1) {
            numbers[i] = Integer.parseInt(stringNumbers.substring(i, i + 1));
        }

        for (int i = 0; i < numbers.length; i += 1) {
            int maxIndex = i;
            for (int j = i + 1; j < numbers.length; j += 1) {
                if(numbers[maxIndex] < numbers[j]) {
                    maxIndex = j;
                }
            }

            if(numbers[maxIndex] > numbers[i]) {
                int temp = numbers[maxIndex];
                numbers[maxIndex] = numbers[i];
                numbers[i] = temp;
            }
        }

        for (int i = 0; i < numbers.length; i += 1) {
            System.out.print(numbers[i]);
        }
    }
}
