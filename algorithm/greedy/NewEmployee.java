import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class NewEmployee {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		List<Integer> answers = new ArrayList<>();

		while (T != 0) {
			int n = scanner.nextInt();
			List<Grade> grades = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				grades.add(new Grade(scanner.nextInt(), scanner.nextInt()));
			}

			Collections.sort(grades);

			int answer = 0;
			int min = Integer.MAX_VALUE;
			for (Grade grade : grades) {
				if (grade.interview < min) {
					answer++;
					min = grade.interview;
				}
			}

			answers.add(answer);

			T--;
		}

		for (Integer answer : answers) {
			System.out.println(answer);
		}
	}


	private static class Grade implements Comparable<Grade> {
		private final int document;
		private final int interview;

		public Grade(int document, int interview) {
			this.document = document;
			this.interview = interview;
		}

		@Override
		public int compareTo(Grade o) {
			if (this.document == o.document) {
				return this.interview - o.interview;
			} else {
				return this.document - o.document;
			}
		}
	}
}
