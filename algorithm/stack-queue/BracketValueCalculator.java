import java.util.Scanner;
import java.util.Stack;

public class BracketValueCalculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();

		Stack<Integer> stack = new Stack<>();

		for (char c : input.toCharArray()) {
			if (c == '(') {
				stack.push(-1); // -1 represents '('
			} else if (c == '[') {
				stack.push(-2); // -2 represents '['
			} else if (c == ')') {
				int val = 0;
				while (!stack.isEmpty() && stack.peek() != -1) {
					val += stack.pop();
				}
				if (stack.isEmpty()) {
					System.out.println(0);
					return;
				}
				stack.pop(); // Remove '('
				stack.push(val == 0 ? 2 : val * 2);
			} else if (c == ']') {
				int val = 0;
				while (!stack.isEmpty() && stack.peek() != -2) {
					val += stack.pop();
				}
				if (stack.isEmpty()) {
					System.out.println(0);
					return;
				}
				stack.pop(); // Remove '['
				stack.push(val == 0 ? 3 : val * 3);
			} else {
				System.out.println(0);
				return;
			}
		}

		int result = 0;
		while (!stack.isEmpty()) {
			int val = stack.pop();
			if (val < 0) {
				System.out.println(0);
				return;
			}
			result += val;
		}

		System.out.println(result);
	}
}
