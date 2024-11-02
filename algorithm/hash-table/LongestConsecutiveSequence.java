import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence
 */

public class LongestConsecutiveSequence {

    // 정렬을 이용한 풀이 O(nlogn)
    public int longestConsecutive(int[] nums) {
        int answer = 0;
        if (nums.length == 0) {
            return answer;
        }

        Arrays.sort(nums); // O(nlogn)

        int length = 0;
        int nextValue = nums[0];
        int previousValue = nums[0] + 1;

        for (int sortedNum : nums) { // O(n)
            if (nextValue == sortedNum) {
                length += 1;
            }
            if (sortedNum == previousValue) {
                continue;
            }
            if (nextValue != sortedNum) {
                length = 1;
            }

            answer = Math.max(answer, length);
            nextValue = sortedNum + 1;
            previousValue = sortedNum;
        }

        return answer;
    }

    // Map을 이용한 풀이 O(n)
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) { // O(n)
            map.put(num, num);
        }

        int answer = 0;

        for (int num : nums) { // O(n)
            int prevNum = num - 1;
            if (!map.containsKey(prevNum) && map.containsKey(num)) {
                int length = 1;
                int nextNum = num + 1;
                while (map.containsKey(nextNum)) {
                    length++;
                    nextNum++;
                }
                answer = Math.max(answer, length);
            }
        }

        return answer;
    }
}
