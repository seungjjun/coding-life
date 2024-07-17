import java.util.Scanner;

public class Subset {

	/*
	문제
	자연수 N이 주어지면 1부터 N까지의 원소를 갖는 집합의 부분집합을 모두 출력하는 프로그램을 작성하세.

	입력
	첫 번째 줄에 자연수 N(1 <= N <= 10)이 주어집니다.

	출력
	첫 번째 줄부터 각 줄에 하나씩 부분집합을 아래와 출력예제와 같은 순서로 출력한다.
	단 공집합은 출력하지 않습니다.

	입력 예제 1
	3

	출력 예제 1
	1 2 3
	1 2
	1 3
	1
	2 3
	2
	3
	 */

	static int N;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();

		visited = new boolean[N + 1];

		dfs(1);
	}

	private static void dfs(int n) {
		if (n == N + 1) {
			String temp = "";
			for (int i = 1; i < visited.length; i++) {
				if (visited[i]) {
					temp += i + " ";
				}
			}
			if (!temp.isEmpty()) {
				System.out.println(temp);
			}
			return;
		}

		visited[n] = true;
		dfs(n + 1);
		visited[n] = false;
		dfs(n + 1);
	}
}
