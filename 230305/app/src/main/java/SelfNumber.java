public class SelfNumber {
    public static void main(String[] args) {
        int[] selfNumbers = new int[100001];

        for (int i = 1; i < selfNumbers.length; i += 1) {
            int result = calculate(i);
            if(result <= 10000) {
                selfNumbers[result] = 1;
            }
        }

        for (int i = 1; i < selfNumbers.length; i += 1) {
            if(selfNumbers[i] != 1) {
                System.out.println(i);
            }
        }
    }

    private static int calculate(int number) {
        int value = number;

        while (number > 0) {
            value += number % 10;
            number /= 10;
        }

        return value;
    }
}
