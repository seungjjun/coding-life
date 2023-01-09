public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 1, 2, 3, 6};

        // 삽입 정렬
        int n = arr.length;

        for (int i = 1; i < n; i += 1) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];

                j = j - 1;
            }

            arr[j + 1] = key;
        }

//      => [1, 2, 3, 4, 6]
    }
}
