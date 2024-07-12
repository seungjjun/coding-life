import java.util.Scanner;
import java.util.Stack;

public class CorrectedBracket {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();

		Stack<Character> stack = new Stack<>();
		for (char c : input.toCharArray()) {
			stack.add(c);
		}

		boolean isAnswered = false;
		int closedBracket = 0;

		while (!stack.isEmpty()) {
			Character bracket = stack.pop();

			if (bracket == ')') {
				closedBracket++;
			}

			if (closedBracket == 0 && bracket == '(') {
				break;
			}

			if (bracket == '(') {
				closedBracket--;
			}

			if (stack.isEmpty() && closedBracket == 0) {
				isAnswered = true;
			}
		}

		if (isAnswered) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

}
