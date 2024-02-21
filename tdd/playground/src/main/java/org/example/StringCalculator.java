package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String number) {
        if (number.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n";
        if (number.startsWith("//")) {
            int delimiterIndex = number.indexOf('\n');
            delimiter = Pattern.quote(number.substring(2, delimiterIndex));
            number = number.substring(delimiterIndex + 1);
        }

        if (number.endsWith(",") || number.endsWith("\n")) {
            throw new RuntimeException();
        }

        String[] nums = number.split(delimiter);
        List<Integer> negatives = new ArrayList<>();
        int sum = 0;
        for (String num : nums) {
            int n = Integer.parseInt(num.trim());
            if (n < 0) {
                negatives.add(n);
            } else if (n <= 1000) {
                sum += n;
            }
        }

        if (!negatives.isEmpty()) {
            throw new RuntimeException("Negative number(s) not allowed: " + negatives);
        }

        return sum;
    }
}
