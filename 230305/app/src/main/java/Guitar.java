import java.util.Scanner;

public class Guitar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lessonNumber = scanner.nextInt();
        int bluLay = scanner.nextInt();

        int[] lessonLength = new int[lessonNumber];

        int start = 0;
        int end = 0;
        for (int i = 0; i < lessonLength.length; i += 1) {
            lessonLength[i] = scanner.nextInt();
            if(lessonLength[i] > start) {
                start = lessonLength[i];
            }
            end += lessonLength[i];
        }

        while (start <= end) {
            int bluLaySize = (start + end) / 2;

            if(isRecord(bluLaySize, bluLay, lessonLength)) {
                end = bluLaySize - 1;
                continue;
            }

            start = bluLaySize + 1;
        }

        System.out.println(start);
    }

    private static boolean isRecord(int bluLaySize, int bluLay, int[] lessonLength) {
        int count = 0;
        int sum = 0;
        for (int i = 0; i < lessonLength.length; i += 1) {
            if(sum + lessonLength[i] > bluLaySize) {
                count += 1;
                sum = 0;
            }
            sum += lessonLength[i];
        }

        if(sum != 0) {
            count += 1;
        }

        if(count > bluLay) {
            return false;
        }

        return true;
    }
}
