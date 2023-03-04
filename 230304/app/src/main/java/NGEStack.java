import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class NGEStack {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int A = bufferedReader.read();

        int[] numbers = new int[A];

        for (int i = 0; i < numbers.length; i += 1) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = numbers.length - 1; i > 0; i -= 1) {
            stack.push(numbers[i]);
        }

        for (int i = 0; i < A; i += 1) {
            int number = stack.pop();

            if(number < stack.peek()) {

            }
        }

    }
}
