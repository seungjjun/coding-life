public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int answer = 0;
        while (left < right) {
            int wid = right - left;
            int hig = Math.min(height[left], height[right]);

            answer = Math.max(answer, wid * hig);

            if (hig == height[left]) {
                left++;
                continue;
            }
            if (hig == height[right]) {
                right++;
            }
        }
        return answer;
    }
}
