import java.util.Scanner;
import java.util.Stack;

public class SortedStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] numbers = new int[n];
        for (int i = 0; i < n; i += 1) {
            numbers[i] = scanner.nextInt();
        }

        Stack<Integer> stack = new Stack<>();

        StringBuffer stringBuffer = new StringBuffer();

        boolean result = true;
        int number = 1;

        for (int i = 0; i < numbers.length; i += 1) {
            if(numbers[i] >= number) {
                while (numbers[i] >= number) {
                    stack.push(number);
                    number += 1;
                    stringBuffer.append("+\n");
                }
                stack.pop();
                stringBuffer.append("-\n");
            }

            if(numbers[i] < number) {
                int a = stack.pop();
                if(a > number) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    stringBuffer.append("-\n");
                }
            }
        }

        if(result) {
            System.out.println(stringBuffer);
        }
    }
}
