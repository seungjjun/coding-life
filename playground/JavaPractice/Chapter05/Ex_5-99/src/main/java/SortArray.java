import java.util.Arrays;
import java.util.Comparator;

public class SortArray {
    public static void main(String[] args) {
        // sort
        Integer[] integers = new Integer[]{3, 1, 5};

        // 오름차순 정렬
        Arrays.sort(integers);

        // 내림차순 정렬
        Arrays.sort(integers, Comparator.reverseOrder());

        // boxing 활용한 내림차순 정렬
        int[] descIntegers = Arrays.stream(integers)
            .sorted((i1, i2) -> Integer.compare(i2, i1))
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
