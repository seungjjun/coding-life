package statics;

import java.util.Arrays;

public class MathArrayUtils {

    private MathArrayUtils() {
    }

    public static int sum(int[] values) {
        return Arrays.stream(values).sum();
    }

    public static double average(int[] values) {
        return Arrays.stream(values).average().getAsDouble();
    }

    public static int min(int[] values) {
        return Arrays.stream(values).min().getAsInt();
    }

    public static int max(int[] values) {
        return Arrays.stream(values).max().getAsInt();
    }
}
