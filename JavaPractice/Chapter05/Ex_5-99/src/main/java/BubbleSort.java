public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 2, 3, 6};

        // 버블 정렬
        int n = arr.length;

        for (int i = 0; i < n - 1; i += 1) {
            for (int j = 0; j < n - i - 1; j += 1) {

                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        while (n != 0) {
            int swap = 0;

            for(int i = 1; i < n; i += 1) {
                if(arr[i - 1] > arr[i]) {
                    int temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;

                    swap = i;
                }
            }

            n = swap;
        }

//      => [1, 2, 3, 4, 6]
    }
}
