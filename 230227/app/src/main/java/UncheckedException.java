public class UncheckedException {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        int index = 10;

//        System.out.println("number = " + numbers[index]);

        try {
            int number = numbers[index];
            System.out.println("number = " + number);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
