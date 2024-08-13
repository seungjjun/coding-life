import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumOfSubarray {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int N = Integer.parseInt(stringTokenizer.nextToken());
		int S = Integer.parseInt(stringTokenizer.nextToken());

		int[] numbers = new int[N];
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
		}

		int answer = Integer.MAX_VALUE;
		int left = 0;
		int sum = 0;

		for (int right = 0; right < N; right++) {
			sum += numbers[right];

			while (sum >= S) {
				answer = Math.min(answer, right - left + 1);
				sum -= numbers[left];
				left++;
			}
		}

		System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
	}
}
