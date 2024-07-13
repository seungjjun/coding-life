import java.util.*;

public class RemoveCharacterParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();

        Stack<Character> stack = new Stack<>();
        List<Character> answers = new ArrayList<>();

        for (char character : string.toCharArray()) {
            if (character == '(') {
                stack.push(character);
                continue;
            }

            if (character == ')') {
                stack.pop();
                continue;
            }

            if (stack.isEmpty()) {
                answers.add(character);
            }
        }

        for (Character answer : answers) {
            System.out.print(answer);
        }
    }
}
