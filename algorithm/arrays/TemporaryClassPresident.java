package cleancode;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int number = scanner.nextInt();
		int[][] numbers = new int[number][number];

		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers[0].length; j++) {
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
		/*
		3번 학생은 1,2,4,5번 학생들과 같은반이었고, 1번 학생은 2,3번 학생과 같은반이었으므로 출력은 3이어야 합니다.

5
1 1 1 1 1
1 1 1 1 1
1 3 4 5 5
3 3 3 3 3
4 4 4 4 4

		1년 2년 3년 4년 5년
	1번	 2  3   1  7  3
	2번	 4  1   9  6  8
	3번	 5  5   2  4  4
	4번	 6  5   2  6  7
	5번	 8  4   2  2  2
	.
	.
	.
		 */