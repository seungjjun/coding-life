import java.util.stream.IntStream;

public class Intstream {
    static final int MAX_SIZE = 10;

    public static void main(String[] args) {
        IntStream.range(0, MAX_SIZE)
                .mapToObj(i -> i + "")
                .forEach(System.out::println);
    }
}
