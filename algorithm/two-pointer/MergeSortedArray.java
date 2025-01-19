public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            for (int i = 0; i < nums1.length; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }

        int pointer1 = m - 1;
        int pointer2 = n - 1;

        int index = m + n - 1;
        while (index >= 0) {
            if (pointer1 < 0) {
                for (int i = 0; i <= pointer2; i++) {
                    nums1[i] = nums2[i];
                }
                return;
            }
            if (pointer2 < 0) {
                return;
            }

            int number1 = nums1[pointer1];
            int number2 = nums2[pointer2];


            if (number2 >= number1) {
                nums1[index--] = number2;
                pointer2--;
                continue;
            }

            nums1[index--] = number1;
            pointer1--;
        }
    }

}
