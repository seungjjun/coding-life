package cleancode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FindAllAnagram {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String S = scanner.next();
		String T = scanner.next();

		int answer = 0;

		Map<Character, Integer> anagramMap = new HashMap<>();
		for (char c : T.toCharArray()) {
			anagramMap.put(c, anagramMap.getOrDefault(c, 0) + 1);
		}

		char[] charArray = S.toCharArray();
		Map<Character, Integer> charMap = new HashMap<>();
		for (int i = 0; i < T.length() - 1; i++) {
			charMap.put(charArray[i], charMap.getOrDefault(charArray[i], 0) + 1);
		}

		int lt = 0;
		for (int rt = T.length() - 1; rt < charArray.length; rt++) {
			charMap.put(charArray[rt], charMap.getOrDefault(charArray[rt], 0) + 1);

			if (anagramMap.equals(charMap)) {
				answer++;
			}

			charMap.put(charArray[lt], charMap.get(charArray[lt]) - 1);
			if (charMap.get(charArray[lt]) == 0) {
				charMap.remove(charArray[lt]);
			}
			lt++;
		}

		System.out.println(answer);
	}
}
