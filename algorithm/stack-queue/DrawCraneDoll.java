import java.util.Scanner;
import java.util.Stack;

public class DrawCraneDoll {

    public static void main(String[] args) {
        DrawCraneDoll drawCraneDoll = new DrawCraneDoll();

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        int M = scanner.nextInt();
        int[] moves = new int[M];

        for (int i = 0; i < M; i++) {
            moves[i] = scanner.nextInt();
        }

        System.out.println(drawCraneDoll.solution(board, moves));
    }

    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();

        int answer = 0;

        for (int move : moves) {
            for (int i = 0; i < board[0].length; i++) {
                int doll = board[i][move - 1];
                if (doll != 0) {
                    board[i][move - 1] = 0;

                    if (!stack.isEmpty() && stack.peek() == doll) {
                        stack.pop();
                        answer += 2;
                        break;
                    }

                    stack.push(doll);
                    break;
                }
            }
        }

        return answer;
    }
}
