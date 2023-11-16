import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CountNumberOfStrings {
    public static void main(String[] arr) {
        // 문자열의 문자 개수 세기

        String string = "abc";

        Map<Character, Integer> result = new HashMap<>();


        // hashMap의 getOrDefault 활용
        for(int i = 0; i < string.length(); i += 1) {
            char letter = string.charAt(i);

            result.put(letter, (result.getOrDefault(letter, 0)) + 1);
        }

        // hashMap의 compute 활용
        for(int i = 0; i < string.length(); i += 1) {
            char letter = string.charAt(i);

            result.compute(letter, (key, value) -> (value == null) ? 1 : value + 1);
        }

        // stream 활용
        Map<Character, Long> result2 = string.chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        System.out.println(result);
    }
}
