import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class WordMath {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		long answer = 0;
		int n = Integer.parseInt(stringTokenizer.nextToken());
		Map<String, Double> score = new HashMap<>();
		for (int i = 0; i < n; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			String alphabet = stringTokenizer.nextToken();

			int length = alphabet.length();
			for (String s : alphabet.split("")) {
				score.put(s, score.getOrDefault(s, 0d) + (Math.pow(10, length - 1)));
				length--;
			}
		}

		List<String> scores = new ArrayList<>(score.keySet());
		scores.sort((o1, o2) -> (int) (score.get(o2) - score.get(o1)));

		int init = 9;
		for (String key : scores) {
			answer += (long) (score.get(key) * init--);
		}

		System.out.println(answer);
	}
}
