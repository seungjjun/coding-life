import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureExample2 {

    private static double syncNumber = 1;
    private static double asyncNumber = 1;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            numbers.add(i);
        }

        // sync process
        long startTime1 = System.currentTimeMillis();
        numbers.forEach(CompletableFutureExample2::syncUpdateNumber);
        long endTime1 = System.currentTimeMillis();
        System.out.println("sync number = " + syncNumber + ", elapsedTime = " + (endTime1 - startTime1) + "ms");

        // async process
        long startTime2 = System.currentTimeMillis();
        List<CompletableFuture<Void>> numberFuture = numbers.stream()
            .map(num -> CompletableFuture.runAsync(() -> asyncUpdateNumber(num), executor)
                .exceptionally(ex -> {
                    System.out.println("Error: " + ex.getMessage());
                    throw new CompletionException(ex);
                })
            )
            .toList();
        CompletableFuture.allOf(numberFuture.toArray(new CompletableFuture[0])).join();
        long endTime2 = System.currentTimeMillis();

        System.out.println("async number = " + asyncNumber + ", elapsedTime = " + (endTime2 - startTime2) + "ms");
        executor.shutdown();
    }

    private static void syncUpdateNumber(int number) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        syncNumber *= number;
    }

    private static void asyncUpdateNumber(int num) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        asyncNumber *= num;
    }
}
