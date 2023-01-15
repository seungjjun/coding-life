import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatedCharacter {
    public static char main(String[] args) {
        // 반복되지 않는 첫 번째 문자 찾기

        String string = "aabbcddef";

        // hashMap을 이용한 나의 풀이
        Map<Character, Integer> result = new HashMap<>();

        for (int i = 0; i < string.length(); i += 1) {
            char letter = string.charAt(i);

            result.put(letter, result.getOrDefault(letter, 0) + 1);
        }

        char firstNonRepeatedCharacter = '0';

        for(char key : result.keySet()) {
            if (result.get(key) == 1) {
                firstNonRepeatedCharacter = key;
                return firstNonRepeatedCharacter;
            }
        }

        return firstNonRepeatedCharacter;
    }

    private static final int EXTENDED_ASCII_CODES = 256;

    public char firstNonRepeatedCharacterV1(String str) {
        // 아스키 코드를 이용한 풀이

        int[] flags = new int[EXTENDED_ASCII_CODES];

        for (int i = 0; i < flags.length; i += 1) {
            flags[i] = -1;
        }

        for (int i = 0; i < str.length(); i += 1) {
            char ch = str.charAt(i);

            if(flags[ch] == -1) {
                flags[ch] = i;
            } else {
                flags[ch] = -2;
            }
        }

        int position = Integer.MAX_VALUE;

        for (int i = 0; i < EXTENDED_ASCII_CODES; i += 1) {
            if(flags[i] >= 0) {
                position = Math.min(position, flags[i]);
            }
        }

        return position == Integer.MAX_VALUE ? Character.MIN_VALUE : str.charAt(position);
    }

    public char firstNonRepeatedCharacterV2(String str) {
        // LinkedHashMap 이용 -> 내가 이용한 HashMap 풀이와 비슷함.

        Map<Character, Integer> chars = new LinkedHashMap<>();

        for (int i = 0; i < str.length(); i += 1) {
            char ch = str.charAt(i);

            chars.compute(ch, (key, value) -> (value == null) ? 1 : value + 1);
        }

        for(Map.Entry<Character, Integer> entry : chars.entrySet()) {
            if (entry.getValue() == 1) {
                return  entry.getKey();
            }
        }

        return Character.MIN_VALUE;
    }
}
