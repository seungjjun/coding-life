import java.util.Scanner;

public class TemporaryClassPresident {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int number = scanner.nextInt();
		int[][] numbers = new int[number][5];

		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < 5; j++) {
				numbers[i][j] = scanner.nextInt();
			}
		}

		int maxCount = 0;
		int student = 0;

		for (int i = 0; i < numbers.length; i++) {
			int count = 0;
			for (int j = 0; j < numbers.length; j++) {
				for (int k = 0; k < 5; k++) {
					if (numbers[i][k] == numbers[j][k]) {
						count++;
						break;
					}
				}
			}

			if (count > maxCount) {
				maxCount = count;
				student = i + 1;
			}
		}

		System.out.println(student);
	}
}
