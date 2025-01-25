public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int index = 1;
        int duplicateCount = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[index++] = nums[i];
                duplicateCount = 1;
                continue;
            }
            if (nums[i] == nums[i - 1] && duplicateCount < 2) {
                duplicateCount++;
                nums[index++] = nums[i];
            }
        }
        return index;
    }

}
