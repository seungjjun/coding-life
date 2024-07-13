import java.util.Scanner;
import java.util.Stack;

public class IronPipe {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.next();
        int answer = 0;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(input.charAt(i));
                continue;
            }

            if (input.charAt(i - 1) == '(' && input.charAt(i) == ')') {
                stack.pop();
                answer += stack.size();
                continue;
            }

            if (input.charAt(i - 1) == ')' && input.charAt(i) == ')') {
                stack.pop();
                answer += 1;
                continue;
            }

            stack.push(input.charAt(i));
        }

        System.out.println(answer);
    }
}
