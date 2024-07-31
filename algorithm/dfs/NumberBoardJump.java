import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static int[][] map = new int[5][5];
	static Set<String> set = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 5; i++) {
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 0; j < 5; j++) {
				int number = Integer.parseInt(stringTokenizer.nextToken());
				map[i][j] = number;
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				StringBuffer stringBuffer = new StringBuffer();
				dfs(i, j, stringBuffer);
			}
		}

		System.out.println(set.size());
	}

	private static void dfs(int y, int x, StringBuffer sum) {
		sum.append(map[y][x]);
		if (sum.length() == 6) {
			set.add(sum.toString());
			return;
		}

		for (int j = 0; j < dx.length; j++) {
			int nextX = dx[j] + x;
			int nextY = dy[j] + y;

			if (nextX >= 0 && nextY >= 0 && nextX < 5 && nextY < 5) {
				dfs(nextY, nextX, sum);
				sum.deleteCharAt(sum.length() - 1);
			}
		}
	}

}
