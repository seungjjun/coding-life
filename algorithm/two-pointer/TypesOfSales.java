import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TypesOfSales {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int K = scanner.nextInt();

		int[] sells = new int[N];

		for (int i = 0; i < N; i++) {
			sells[i] = scanner.nextInt();
		}

		List<Integer> answers = new ArrayList<>();

		Map<Integer, Integer> selling = new HashMap<>();

		for (int i = 0; i < K; i++) {
			selling.put(sells[i], selling.getOrDefault(sells[i], 0) + 1);
		}
		answers.add(selling.size());

		int lt = 0;
		for (int rt = K; rt < sells.length; rt++) {
			selling.put(sells[lt], selling.get(sells[lt]) - 1);

			if (selling.get(sells[lt]) == 0) {
				selling.remove(sells[lt]);
			}

			lt++;

			selling.put(sells[rt], selling.getOrDefault(sells[rt], 0) + 1);

			answers.add(selling.size());
		}

		for (Integer number : answers) {
			System.out.print(number + " ");
		}
	}
}
