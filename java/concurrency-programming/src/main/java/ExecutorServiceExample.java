import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<String> submit = executorService.submit(() -> {
            try {
                Thread.sleep(1000);
                return "Hello World";
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        long currentTimeMillis = System.currentTimeMillis();

        // blocking until retrieves result
        String result = submit.get();

        long retrievedResultTimeMillis = System.currentTimeMillis();
        System.out.println("result = " + result + ", executor time = " + (retrievedResultTimeMillis - currentTimeMillis));

        executorService.shutdown();
    }
}
