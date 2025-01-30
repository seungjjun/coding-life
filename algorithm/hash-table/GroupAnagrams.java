import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    /*
    Best practice (use sorting)

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagram = new HashMap<>();
        for (String word : strs) {
            char[] alphabets = word.toCharArray();
            Arrays.sort(alphabets);
            String sortedWord = new String(alphabets);

            if (!anagram.containsKey(sortedWord)) {
                anagram.put(sortedWord, new ArrayList<>());
            }

            anagram.get(sortedWord).add(word);
        }

        return new ArrayList<>(anagram.values());
    }
     */

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<>();
        boolean[] checklist = new boolean[strs.length];
        Map<Character, Integer> anagram = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            if (checklist[i]) {
                continue;
            }
            List<String> array = new ArrayList<>();

            String word = strs[i];
            array.add(word);

            for (char alphabet : word.toCharArray()) {
                anagram.put(alphabet, anagram.getOrDefault(alphabet, 0) + 1);
            }
            checklist[i] = true;

            for (int j = 0; j < checklist.length; j++) {
                if (checklist[j]) {
                    continue;
                }

                String otherWord = strs[j];
                if (word.length() != otherWord.length()) {
                    continue;
                }

                if (word.isEmpty()) {
                    checklist[j] = true;
                    array.add(otherWord);
                }

                Map<Character, Integer> otherAnagram = new HashMap<>(anagram);
                for (char otherAlphabet : otherWord.toCharArray()) {
                    if (!otherAnagram.containsKey(otherAlphabet)) {
                        break;
                    }

                    Integer count = otherAnagram.get(otherAlphabet);
                    if (count == 1) {
                        otherAnagram.remove(otherAlphabet);
                    } else {
                        otherAnagram.put(otherAlphabet, count - 1);
                    }

                    if (otherAnagram.isEmpty()) {
                        checklist[j] = true;
                        array.add(otherWord);
                    }
                }
            }

            anagram.clear();
            answer.add(array);
        }

        return answer;
    }
}
